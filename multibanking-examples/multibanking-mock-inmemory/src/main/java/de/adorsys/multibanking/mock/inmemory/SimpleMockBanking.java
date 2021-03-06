package de.adorsys.multibanking.mock.inmemory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.adorsys.multibanking.mock.domain.*;
import de.adorsys.multibanking.mock.loader.*;
import de.adorsys.onlinebanking.mock.MockBanking;
import domain.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Mock Banking operating on the base of a json file.
 *
 * @author fpo
 */
public class SimpleMockBanking extends MockBanking {
    private BookingCategoryData bookingCategoryData;
    private List<? extends Bank> banks;
    private ObjectMapper mapper = new ObjectMapper();
    private MockAccount data = new MockAccount();

    public SimpleMockBanking() {
        try {
            load(null, null, null);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public SimpleMockBanking(InputStream bookingCategoryStream, InputStream banksStream, InputStream bookingsStream) {
        try {
            load(bookingCategoryStream, banksStream, bookingsStream);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public LoadAccountInformationResponse loadBankAccounts(LoadAccountInformationRequest loadAccountInformationRequest) {
        List<BankAccount> bankAccounts = data.loadBankAccounts(loadAccountInformationRequest.getBankAccess(), loadAccountInformationRequest.getBankCode(), loadAccountInformationRequest.getPin());
        return LoadAccountInformationResponse.builder()
                .bankAccounts(bankAccounts)
                .build();
    }

    @Override
    public LoadBookingsResponse loadBookings(LoadBookingsRequest loadBookingsRequest) {
        String bankLogin = loadBookingsRequest.getBankAccess().getBankLogin();
        String iban = loadBookingsRequest.getBankAccount().getIban();
        BankAccessData bankAccessData = data.accessOrException(bankLogin);
        bankAccessData.checkPin(loadBookingsRequest.getPin());
        BankAccountData accountData = data.accessOrException(bankLogin).accountDataOrException(iban);
        List<Booking> bookings = accountData.bookings();
        List<StandingOrder> standingOrders = new ArrayList<>(accountData.standingOrders().values());
        return LoadBookingsResponse.builder().bookings(bookings).standingOrders(standingOrders).build();
    }

    private void load(InputStream bookingCategoryStream, InputStream banksStream, InputStream bookingsStream) throws IOException {
        if (bookingCategoryStream == null)
            bookingCategoryStream = SimpleMockBanking.class.getResourceAsStream("/booking_category.json");

        bookingCategoryData = mapper.readValue(bookingCategoryStream, BookingCategoryData.class);

        if (banksStream == null)
            banksStream = SimpleMockBanking.class.getResourceAsStream("/mock_bank.json");

        banks = mapper.readValue(banksStream, new TypeReference<List<XLSBank>>() {
        });

        BankAccesLoader bankAccesLoader = new BankAccesLoader(data);
        MockBankCatalogue bankCatalogue = new MockBankCatalogue();
        bankCatalogue.setBanks(banks);
        BankAccountLoader bankAccountLoader = new BankAccountLoader(data, bankCatalogue);
        BookingLoader bookingLoader = new BookingLoader(data);
        StandingOrderLoader standingOrderLoader = new StandingOrderLoader(data);
        DataSheetLoader dataSheetLoader = new DataSheetLoader(bankAccesLoader, bankAccountLoader, bookingLoader, standingOrderLoader);

        if (bookingsStream == null)
            bookingsStream = SimpleMockBanking.class.getResourceAsStream("/mock_bank.xls");

        dataSheetLoader.loadDataSheet(bookingsStream);
    }

}
