package br.com.vanguardasistemas.application.mapper;

import br.com.vanguardasistemas.application.dto.itbipaymentslip.in.ItbiPaymentSlipInsertInDTO;
import br.com.vanguardasistemas.domain.model.ItbiPaymentSlip;
import br.com.vanguardasistemas.domain.model.Person;
import br.com.vanguardasistemas.domain.model.RealEstate;
import br.com.vanguardasistemas.domain.model.NotaryOffice;
import br.com.vanguardasistemas.mocks.PersonMocks;
import br.com.vanguardasistemas.mocks.RealEstateMocks;
import br.com.vanguardasistemas.mocks.NotaryOfficeMocks;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class ItbiPaymentSlipDTOMapperTest {

  private final ItbiPaymentSlipDTOMapper mapper = new ItbiPaymentSlipDTOMapper();

  @Test
  void deveMapearParaDomainCorretamente() {
    Person taxPayer = PersonMocks.defaultPerson(null);
    RealEstate realEstate = RealEstateMocks.defaultRealEstate(null);
    NotaryOffice notaryOffice = NotaryOfficeMocks.defaultNotaryOffice();
    NotaryOffice recordOffice = NotaryOfficeMocks.defaultRecordOffice();
    Person realEstateGrantee = PersonMocks.defaultGrantee(null);
    Person realEstateGrantor = PersonMocks.defaultGrantor(null);

    ItbiPaymentSlipInsertInDTO dto = new ItbiPaymentSlipInsertInDTO(
      taxPayer.getPersonId(),
      realEstate.getRealEstateId(),
      notaryOffice.getNotaryOfficeId(),
      recordOffice.getNotaryOfficeId(),
      realEstateGrantee.getPersonId(),
      realEstateGrantor.getPersonId(),
      "VENDA",
      "REG123"
    );

    ItbiPaymentSlip result = mapper.toDomain(
      dto,
      taxPayer,
      realEstate,
      notaryOffice,
      recordOffice,
      realEstateGrantee,
      realEstateGrantor
    );

    Assertions.assertNotNull(result);
    Assertions.assertEquals(taxPayer, result.getTaxPayer());
    Assertions.assertEquals(realEstate, result.getRealEstate());
    Assertions.assertEquals(notaryOffice, result.getNotaryOffice());
    Assertions.assertEquals(recordOffice, result.getRecordOffice());
    Assertions.assertEquals(realEstateGrantee, result.getRealEstateGrantee());
    Assertions.assertEquals(realEstateGrantor, result.getRealEstateGrantor());
    Assertions.assertEquals("VENDA", result.getTransactionType());
    Assertions.assertEquals("REG123", result.getOfficialRecordCode());
  }
} 