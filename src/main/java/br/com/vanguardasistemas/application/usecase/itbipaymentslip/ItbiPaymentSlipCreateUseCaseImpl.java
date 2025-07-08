package br.com.vanguardasistemas.application.usecase.itbipaymentslip;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vanguardasistemas.application.dto.itbipaymentslip.in.ItbiPaymentSlipInsertInDTO;
import br.com.vanguardasistemas.application.mapper.ItbiPaymentSlipDTOMapper;
import br.com.vanguardasistemas.domain.model.ItbiPaymentSlip;
import br.com.vanguardasistemas.domain.repository.ItbiPaymentSlipRepository;
import br.com.vanguardasistemas.domain.repository.PersonRepository;
import br.com.vanguardasistemas.domain.repository.RealEstateRepository;
import br.com.vanguardasistemas.domain.repository.NotaryOfficeRepository;
import br.com.vanguardasistemas.domain.model.Person;
import br.com.vanguardasistemas.domain.model.RealEstate;
import br.com.vanguardasistemas.domain.model.NotaryOffice;
import java.util.UUID;
import br.com.vanguardasistemas.application.exception.NotFoundException;

@Service
public class ItbiPaymentSlipCreateUseCaseImpl implements ItbiPaymentSlipCreateUseCase {

  private final ItbiPaymentSlipRepository itbiPaymentSlipRepository;
  private final ItbiPaymentSlipDTOMapper itbiPaymentSlipDTOMapper;
  private final PersonRepository personRepository;
  private final RealEstateRepository realEstateRepository;
  private final NotaryOfficeRepository notaryOfficeRepository;

  public ItbiPaymentSlipCreateUseCaseImpl(
    ItbiPaymentSlipRepository itbiPaymentSlipRepository,
    ItbiPaymentSlipDTOMapper itbiPaymentSlipDTOMapper,
    PersonRepository personRepository,
    RealEstateRepository realEstateRepository,
    NotaryOfficeRepository notaryOfficeRepository
  ) {
    this.itbiPaymentSlipRepository = itbiPaymentSlipRepository;
    this.itbiPaymentSlipDTOMapper = itbiPaymentSlipDTOMapper;
    this.personRepository = personRepository;
    this.realEstateRepository = realEstateRepository;
    this.notaryOfficeRepository = notaryOfficeRepository;
  }

  @Override
  @Transactional
  public ItbiPaymentSlip create(ItbiPaymentSlipInsertInDTO itbiPaymentSlipInsertInDTO) {
    UUID taxPayerId = itbiPaymentSlipInsertInDTO.taxPayerId();
    Person taxPayer = personRepository.findById(taxPayerId);
    if (taxPayer == null) {
      throw new NotFoundException("Person", taxPayerId);
    }

    UUID realEstateId = itbiPaymentSlipInsertInDTO.realEstateId();
    RealEstate realEstate = realEstateRepository.findById(realEstateId);
    if (realEstate == null) {
      throw new NotFoundException("RealEstate", realEstateId);
    }

    UUID notaryOfficeId = itbiPaymentSlipInsertInDTO.notaryOfficeId();
    NotaryOffice notaryOffice = notaryOfficeRepository.findById(notaryOfficeId);
    if (notaryOffice == null) {
      throw new NotFoundException("NotaryOffice", notaryOfficeId);
    }

    UUID recordOfficeId = itbiPaymentSlipInsertInDTO.recordOfficeId();
    NotaryOffice recordOffice = notaryOfficeRepository.findById(recordOfficeId);
    if (recordOffice == null) {
      throw new NotFoundException("NotaryOffice", recordOfficeId);
    }

    UUID realEstateGranteeId = itbiPaymentSlipInsertInDTO.realEstateGranteeId();
    Person realEstateGrantee = personRepository.findById(realEstateGranteeId);
    if (realEstateGrantee == null) {
      throw new NotFoundException("Person", realEstateGranteeId);
    }

    Person realEstateGrantor = personRepository.findById(
      itbiPaymentSlipInsertInDTO.realEstateGrantorId()
    );
    if (realEstateGrantor == null) {
      throw new NotFoundException(
        "Person",
        itbiPaymentSlipInsertInDTO.realEstateGrantorId()
      );
    }

    ItbiPaymentSlip itbiPaymentSlip = itbiPaymentSlipDTOMapper.toDomain(
      itbiPaymentSlipInsertInDTO,
      taxPayer,
      realEstate,
      notaryOffice,
      recordOffice,
      realEstateGrantee,
      realEstateGrantor
    );

    return itbiPaymentSlipRepository.save(itbiPaymentSlip);
  }
}