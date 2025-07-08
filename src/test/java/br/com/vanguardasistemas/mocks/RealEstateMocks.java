package br.com.vanguardasistemas.mocks;

import br.com.vanguardasistemas.domain.model.Address;
import br.com.vanguardasistemas.domain.model.RealEstate;
import br.com.vanguardasistemas.application.dto.realestate.in.RealEstateInsertInDTO;
import br.com.vanguardasistemas.application.dto.address.in.AddressInsertInDTO;
import java.util.UUID;

public class RealEstateMocks {
  public static final UUID REAL_ESTATE_ID = UUID.fromString("22222222-2222-2222-2222-222222222222");
  public static final String PROPERTY_TYPE = "CASA";
  public static final String PROPERTY_NAME = "Casa das Flores";
  public static final String DESCRIPTION = "Casa residencial";
  public static final String TOTAL_AREA_DESCRIPTION = "150m²";
  public static final String BUILT_AREA_DESCRIPTION = "120m²";
  public static final String IDEAL_AREA = "Residencial";
  public static final String PROPERTY_REGISTRATION_NUMBER = "123456";
  public static final String ADDITIONAL_NOTES = "Observações adicionais";

  public static RealEstateInsertInDTO defaultRealEstateInsertInDTO(AddressInsertInDTO address) {
    return new RealEstateInsertInDTO(
      PROPERTY_TYPE,
      PROPERTY_NAME,
      DESCRIPTION,
      address,
      TOTAL_AREA_DESCRIPTION,
      BUILT_AREA_DESCRIPTION,
      IDEAL_AREA,
      PROPERTY_REGISTRATION_NUMBER,
      ADDITIONAL_NOTES
    );
  }

  public static RealEstate defaultRealEstate(Address address) {
    return RealEstate.builder()
      .realEstateId(REAL_ESTATE_ID)
      .propertyType(PROPERTY_TYPE)
      .propertyName(PROPERTY_NAME)
      .description(DESCRIPTION)
      .address(address)
      .totalAreaDescription(TOTAL_AREA_DESCRIPTION)
      .builtAreaDescription(BUILT_AREA_DESCRIPTION)
      .idealArea(IDEAL_AREA)
      .propertyRegistrationNumber(PROPERTY_REGISTRATION_NUMBER)
      .additionalNotes(ADDITIONAL_NOTES)
      .build();
  }
} 