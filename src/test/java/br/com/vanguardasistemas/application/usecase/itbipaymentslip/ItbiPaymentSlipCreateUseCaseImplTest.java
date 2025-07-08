package br.com.vanguardasistemas.application.usecase.itbipaymentslip;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.vanguardasistemas.application.dto.itbipaymentslip.in.ItbiPaymentSlipInsertInDTO;
import br.com.vanguardasistemas.application.exception.NotFoundException;
import br.com.vanguardasistemas.application.mapper.ItbiPaymentSlipDTOMapper;
import br.com.vanguardasistemas.domain.model.ItbiPaymentSlip;
import br.com.vanguardasistemas.domain.model.NotaryOffice;
import br.com.vanguardasistemas.domain.model.Person;
import br.com.vanguardasistemas.domain.model.RealEstate;
import br.com.vanguardasistemas.domain.repository.ItbiPaymentSlipRepository;
import br.com.vanguardasistemas.domain.repository.NotaryOfficeRepository;
import br.com.vanguardasistemas.domain.repository.PersonRepository;
import br.com.vanguardasistemas.domain.repository.RealEstateRepository;
import br.com.vanguardasistemas.mocks.NotaryOfficeMocks;
import br.com.vanguardasistemas.mocks.PersonMocks;
import br.com.vanguardasistemas.mocks.RealEstateMocks;

@ExtendWith(MockitoExtension.class)
class ItbiPaymentSlipCreateUseCaseImplTest {

  @Mock
  private ItbiPaymentSlipRepository itbiPaymentSlipRepository;
  @Mock
  private ItbiPaymentSlipDTOMapper itbiPaymentSlipDTOMapper;
  @Mock
  private PersonRepository personRepository;
  @Mock
  private RealEstateRepository realEstateRepository;
  @Mock
  private NotaryOfficeRepository notaryOfficeRepository;

  private ItbiPaymentSlipCreateUseCaseImpl itbiPaymentSlipCreateUseCase;

  @BeforeEach
  void setUp() {
    itbiPaymentSlipCreateUseCase = new ItbiPaymentSlipCreateUseCaseImpl(
      itbiPaymentSlipRepository,
      itbiPaymentSlipDTOMapper,
      personRepository,
      realEstateRepository,
      notaryOfficeRepository
    );
  }

  @Test
  void shouldCreateItbiPaymentSlipSuccessfully() {
    UUID taxPayerId = PersonMocks.PERSON_ID;
    UUID realEstateId = RealEstateMocks.REAL_ESTATE_ID;
    UUID notaryOfficeId = UUID.fromString("33333333-3333-3333-3333-333333333333");
    UUID recordOfficeId = UUID.fromString("44444444-4444-4444-4444-444444444444");
    UUID realEstateGranteeId = PersonMocks.GRANTEE_ID;
    UUID realEstateGrantorId = PersonMocks.GRANTOR_ID;

    ItbiPaymentSlipInsertInDTO dto = new ItbiPaymentSlipInsertInDTO(
      taxPayerId,
      realEstateId,
      notaryOfficeId,
      recordOfficeId,
      realEstateGranteeId,
      realEstateGrantorId,
      "VENDA",
      "ABC123"
    );

    Person taxPayer = PersonMocks.defaultPerson(null);
    RealEstate realEstate = RealEstateMocks.defaultRealEstate(null);
    NotaryOffice notaryOffice = NotaryOfficeMocks.defaultNotaryOffice();
    NotaryOffice recordOffice = NotaryOfficeMocks.defaultRecordOffice();
    Person realEstateGrantee = PersonMocks.defaultGrantee(null);
    Person realEstateGrantor = PersonMocks.defaultGrantor(null);

    ItbiPaymentSlip expectedItbiPaymentSlip = ItbiPaymentSlip.builder()
      .taxPayer(taxPayer)
      .realEstate(realEstate)
      .notaryOffice(notaryOffice)
      .recordOffice(recordOffice)
      .realEstateGrantee(realEstateGrantee)
      .realEstateGrantor(realEstateGrantor)
      .transactionType("VENDA")
      .officialRecordCode("ABC123")
      .build();

    when(personRepository.findById(taxPayerId)).thenReturn(taxPayer);
    when(realEstateRepository.findById(realEstateId)).thenReturn(realEstate);
    when(notaryOfficeRepository.findById(notaryOfficeId)).thenReturn(notaryOffice);
    when(notaryOfficeRepository.findById(recordOfficeId)).thenReturn(recordOffice);
    when(personRepository.findById(realEstateGranteeId)).thenReturn(realEstateGrantee);
    when(personRepository.findById(realEstateGrantorId)).thenReturn(realEstateGrantor);
    when(itbiPaymentSlipDTOMapper.toDomain(dto, taxPayer, realEstate, notaryOffice, recordOffice, realEstateGrantee, realEstateGrantor))
      .thenReturn(expectedItbiPaymentSlip);
    when(itbiPaymentSlipRepository.save(expectedItbiPaymentSlip)).thenReturn(expectedItbiPaymentSlip);

    ItbiPaymentSlip result = itbiPaymentSlipCreateUseCase.create(dto);

    assertNotNull(result);
    assertEquals(expectedItbiPaymentSlip, result);
    assertEquals("VENDA", result.getTransactionType());
    assertEquals("ABC123", result.getOfficialRecordCode());
    assertEquals(PersonMocks.PERSON_ID, result.getTaxPayer().getPersonId());
    assertEquals(RealEstateMocks.REAL_ESTATE_ID, result.getRealEstate().getRealEstateId());

    verify(personRepository).findById(taxPayerId);
    verify(realEstateRepository).findById(realEstateId);
    verify(notaryOfficeRepository).findById(notaryOfficeId);
    verify(notaryOfficeRepository).findById(recordOfficeId);
    verify(personRepository).findById(realEstateGranteeId);
    verify(personRepository).findById(realEstateGrantorId);
    verify(itbiPaymentSlipDTOMapper).toDomain(dto, taxPayer, realEstate, notaryOffice, recordOffice, realEstateGrantee, realEstateGrantor);
    verify(itbiPaymentSlipRepository).save(expectedItbiPaymentSlip);
  }

  @Test
  void shouldThrowNotFoundExceptionWhenTaxPayerNotFound() {
    UUID invalidTaxPayerId = UUID.fromString("aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa");
    ItbiPaymentSlipInsertInDTO dto = new ItbiPaymentSlipInsertInDTO(
      invalidTaxPayerId,
      RealEstateMocks.REAL_ESTATE_ID,
      NotaryOfficeMocks.NOTARY_OFFICE_ID,
      NotaryOfficeMocks.RECORD_OFFICE_ID,
      PersonMocks.GRANTEE_ID,
      PersonMocks.GRANTOR_ID,
      "VENDA",
      "ABC123"
    );

    when(personRepository.findById(invalidTaxPayerId)).thenReturn(null);

    NotFoundException exception = assertThrows(NotFoundException.class, () -> {
      itbiPaymentSlipCreateUseCase.create(dto);
    });

    assertEquals("Record of type 'Person' not found: " + invalidTaxPayerId, exception.getMessage());
    verify(personRepository).findById(invalidTaxPayerId);
    verifyNoMoreInteractions(realEstateRepository, notaryOfficeRepository, itbiPaymentSlipDTOMapper, itbiPaymentSlipRepository);
  }

  @Test
  void shouldThrowNotFoundExceptionWhenRealEstateNotFound() {
    UUID invalidRealEstateId = UUID.fromString("bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb");
    ItbiPaymentSlipInsertInDTO dto = new ItbiPaymentSlipInsertInDTO(
      PersonMocks.PERSON_ID,
      invalidRealEstateId,
      NotaryOfficeMocks.NOTARY_OFFICE_ID,
      NotaryOfficeMocks.RECORD_OFFICE_ID,
      PersonMocks.GRANTEE_ID,
      PersonMocks.GRANTOR_ID,
      "VENDA",
      "ABC123"
    );
    when(personRepository.findById(PersonMocks.PERSON_ID)).thenReturn(PersonMocks.defaultPerson(null));
    when(realEstateRepository.findById(invalidRealEstateId)).thenReturn(null);

    NotFoundException exception = assertThrows(NotFoundException.class, () -> {
      itbiPaymentSlipCreateUseCase.create(dto);
    });

    assertEquals("Record of type 'RealEstate' not found: " + invalidRealEstateId, exception.getMessage());
    verify(personRepository).findById(PersonMocks.PERSON_ID);
    verify(realEstateRepository).findById(invalidRealEstateId);
    verifyNoMoreInteractions(notaryOfficeRepository, itbiPaymentSlipDTOMapper, itbiPaymentSlipRepository);
  }

  @Test
  void shouldThrowNotFoundExceptionWhenNotaryOfficeNotFound() {
    UUID invalidNotaryOfficeId = UUID.fromString("cccccccc-cccc-cccc-cccc-cccccccccccc");
    ItbiPaymentSlipInsertInDTO dto = new ItbiPaymentSlipInsertInDTO(
      PersonMocks.PERSON_ID,
      RealEstateMocks.REAL_ESTATE_ID,
      invalidNotaryOfficeId,
      NotaryOfficeMocks.RECORD_OFFICE_ID,
      PersonMocks.GRANTEE_ID,
      PersonMocks.GRANTOR_ID,
      "VENDA",
      "ABC123"
    );
    when(personRepository.findById(PersonMocks.PERSON_ID)).thenReturn(PersonMocks.defaultPerson(null));
    when(realEstateRepository.findById(RealEstateMocks.REAL_ESTATE_ID)).thenReturn(RealEstateMocks.defaultRealEstate(null));
    when(notaryOfficeRepository.findById(invalidNotaryOfficeId)).thenReturn(null);

    NotFoundException exception = assertThrows(NotFoundException.class, () -> {
      itbiPaymentSlipCreateUseCase.create(dto);
    });

    assertEquals("Record of type 'NotaryOffice' not found: " + invalidNotaryOfficeId, exception.getMessage());
    verify(personRepository).findById(PersonMocks.PERSON_ID);
    verify(realEstateRepository).findById(RealEstateMocks.REAL_ESTATE_ID);
    verify(notaryOfficeRepository).findById(invalidNotaryOfficeId);
    verifyNoMoreInteractions(itbiPaymentSlipDTOMapper, itbiPaymentSlipRepository);
  }

  @Test
  void shouldThrowNotFoundExceptionWhenRecordOfficeNotFound() {
    UUID invalidRecordOfficeId = UUID.fromString("dddddddd-dddd-dddd-dddd-dddddddddddd");
    ItbiPaymentSlipInsertInDTO dto = new ItbiPaymentSlipInsertInDTO(
      PersonMocks.PERSON_ID,
      RealEstateMocks.REAL_ESTATE_ID,
      NotaryOfficeMocks.NOTARY_OFFICE_ID,
      invalidRecordOfficeId,
      PersonMocks.GRANTEE_ID,
      PersonMocks.GRANTOR_ID,
      "VENDA",
      "ABC123"
    );
    when(personRepository.findById(PersonMocks.PERSON_ID)).thenReturn(PersonMocks.defaultPerson(null));
    when(realEstateRepository.findById(RealEstateMocks.REAL_ESTATE_ID)).thenReturn(RealEstateMocks.defaultRealEstate(null));
    when(notaryOfficeRepository.findById(NotaryOfficeMocks.NOTARY_OFFICE_ID)).thenReturn(NotaryOfficeMocks.defaultNotaryOffice());
    when(notaryOfficeRepository.findById(invalidRecordOfficeId)).thenReturn(null);

    NotFoundException exception = assertThrows(NotFoundException.class, () -> {
      itbiPaymentSlipCreateUseCase.create(dto);
    });

    assertEquals("Record of type 'NotaryOffice' not found: " + invalidRecordOfficeId, exception.getMessage());
    verify(personRepository).findById(PersonMocks.PERSON_ID);
    verify(realEstateRepository).findById(RealEstateMocks.REAL_ESTATE_ID);
    verify(notaryOfficeRepository).findById(NotaryOfficeMocks.NOTARY_OFFICE_ID);
    verify(notaryOfficeRepository).findById(invalidRecordOfficeId);
    verifyNoMoreInteractions(itbiPaymentSlipDTOMapper, itbiPaymentSlipRepository);
  }

  @Test
  void shouldThrowNotFoundExceptionWhenGranteeNotFound() {
    UUID invalidGranteeId = UUID.fromString("eeeeeeee-eeee-eeee-eeee-eeeeeeeeeeee");
    ItbiPaymentSlipInsertInDTO dto = new ItbiPaymentSlipInsertInDTO(
      PersonMocks.PERSON_ID,
      RealEstateMocks.REAL_ESTATE_ID,
      NotaryOfficeMocks.NOTARY_OFFICE_ID,
      NotaryOfficeMocks.RECORD_OFFICE_ID,
      invalidGranteeId,
      PersonMocks.GRANTOR_ID,
      "VENDA",
      "ABC123"
    );
    when(personRepository.findById(PersonMocks.PERSON_ID)).thenReturn(PersonMocks.defaultPerson(null));
    when(realEstateRepository.findById(RealEstateMocks.REAL_ESTATE_ID)).thenReturn(RealEstateMocks.defaultRealEstate(null));
    when(notaryOfficeRepository.findById(NotaryOfficeMocks.NOTARY_OFFICE_ID)).thenReturn(NotaryOfficeMocks.defaultNotaryOffice());
    when(notaryOfficeRepository.findById(NotaryOfficeMocks.RECORD_OFFICE_ID)).thenReturn(NotaryOfficeMocks.defaultRecordOffice());
    when(personRepository.findById(invalidGranteeId)).thenReturn(null);

    NotFoundException exception = assertThrows(NotFoundException.class, () -> {
      itbiPaymentSlipCreateUseCase.create(dto);
    });

    assertEquals("Record of type 'Person' not found: " + invalidGranteeId, exception.getMessage());
    verify(personRepository).findById(PersonMocks.PERSON_ID);
    verify(realEstateRepository).findById(RealEstateMocks.REAL_ESTATE_ID);
    verify(notaryOfficeRepository).findById(NotaryOfficeMocks.NOTARY_OFFICE_ID);
    verify(notaryOfficeRepository).findById(NotaryOfficeMocks.RECORD_OFFICE_ID);
    verify(personRepository).findById(invalidGranteeId);
    verifyNoMoreInteractions(itbiPaymentSlipDTOMapper, itbiPaymentSlipRepository);
  }

  @Test
  void shouldThrowNotFoundExceptionWhenGrantorNotFound() {
    UUID invalidGrantorId = UUID.fromString("ffffffff-ffff-ffff-ffff-ffffffffffff");
    ItbiPaymentSlipInsertInDTO dto = new ItbiPaymentSlipInsertInDTO(
      PersonMocks.PERSON_ID,
      RealEstateMocks.REAL_ESTATE_ID,
      NotaryOfficeMocks.NOTARY_OFFICE_ID,
      NotaryOfficeMocks.RECORD_OFFICE_ID,
      PersonMocks.GRANTEE_ID,
      invalidGrantorId,
      "VENDA",
      "ABC123"
    );
    when(personRepository.findById(PersonMocks.PERSON_ID)).thenReturn(PersonMocks.defaultPerson(null));
    when(realEstateRepository.findById(RealEstateMocks.REAL_ESTATE_ID)).thenReturn(RealEstateMocks.defaultRealEstate(null));
    when(notaryOfficeRepository.findById(NotaryOfficeMocks.NOTARY_OFFICE_ID)).thenReturn(NotaryOfficeMocks.defaultNotaryOffice());
    when(notaryOfficeRepository.findById(NotaryOfficeMocks.RECORD_OFFICE_ID)).thenReturn(NotaryOfficeMocks.defaultRecordOffice());
    when(personRepository.findById(PersonMocks.GRANTEE_ID)).thenReturn(PersonMocks.defaultGrantee(null));
    when(personRepository.findById(invalidGrantorId)).thenReturn(null);

    NotFoundException exception = assertThrows(NotFoundException.class, () -> {
      itbiPaymentSlipCreateUseCase.create(dto);
    });

    assertEquals("Record of type 'Person' not found: " + invalidGrantorId, exception.getMessage());
    verify(personRepository).findById(PersonMocks.PERSON_ID);
    verify(realEstateRepository).findById(RealEstateMocks.REAL_ESTATE_ID);
    verify(notaryOfficeRepository).findById(NotaryOfficeMocks.NOTARY_OFFICE_ID);
    verify(notaryOfficeRepository).findById(NotaryOfficeMocks.RECORD_OFFICE_ID);
    verify(personRepository).findById(PersonMocks.GRANTEE_ID);
    verify(personRepository).findById(invalidGrantorId);
    verifyNoMoreInteractions(itbiPaymentSlipDTOMapper, itbiPaymentSlipRepository);
  }
} 