package hbci4java;

import domain.LoadBookingsRequest;
import org.apache.commons.lang3.StringUtils;
import org.kapott.hbci.manager.BankInfo;
import org.kapott.hbci.manager.HBCIDialog;
import org.kapott.hbci.manager.HBCIUtils;

import java.util.HashMap;

public class HbciDialogFactory {

    public static HBCIDialog createDialog(HbciDialogRequest dialogRequest) {
        return createDialog(dialogRequest, null);
    }

    public static HBCIDialog createDialog(HbciDialogRequest dialogRequest, HbciCallback callback) {
        return createDialog(null, dialogRequest, callback);
    }

    private static HBCIDialog createDialog(HbciPassport passport, HbciDialogRequest dialogRequest, HbciCallback callback) {
        BankInfo bankInfo = HBCIUtils.getBankInfo(dialogRequest.getBankCode());

        if (passport == null) {
            passport = createPassport(bankInfo.getPinTanVersion().getId(), dialogRequest.getBankCode(), dialogRequest.getCustomerId(), dialogRequest.getLogin(), callback);

            if (dialogRequest.getHbciPassportState() != null) {
                HbciPassport.State.readJson(dialogRequest.getHbciPassportState()).apply(passport);
            }
        }

        passport.setPIN(dialogRequest.getPin());

        String url = bankInfo.getPinTanAddress();
        String proxyPrefix = System.getProperty("proxyPrefix", null);
        if (proxyPrefix != null) {
            url = proxyPrefix + url;
        }
        passport.setHost(url);

        return new HBCIDialog(passport);
    }

    public static HbciPassport createPassport(String hbciVersion, String bankCode, String customerId, String login, HbciCallback callback) {
        HashMap<String, String> properties = new HashMap<>();
        properties.put("kernel.rewriter", "InvalidSegment,WrongStatusSegOrder,WrongSequenceNumbers,MissingMsgRef,HBCIVersion,SigIdLeadingZero,InvalidSuppHBCIVersion,SecTypeTAN,KUmsDelimiters,KUmsEmptyBDateSets");
        properties.put("log.loglevel.default", "2");
        properties.put("default.hbciversion", "FinTS3");
        properties.put("client.passport.PinTan.checkcert", "1");
        properties.put("client.passport.PinTan.init", "1");
        properties.put("client.errors.ignoreJobNotSupported", "yes");

        properties.put("client.passport.country", "DE");
        properties.put("client.passport.blz", bankCode);
        properties.put("client.passport.customerId", customerId);
        properties.put("client.errors.ignoreCryptErrors", "yes");

        if (StringUtils.isNotBlank(login)) {
            properties.put("client.passport.userId", login);
        }

        return new HbciPassport(hbciVersion, properties, callback);
    }

}
