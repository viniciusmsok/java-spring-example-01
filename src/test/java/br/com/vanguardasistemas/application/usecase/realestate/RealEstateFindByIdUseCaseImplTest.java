package br.com.vanguardasistemas.application.usecase.realestate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.vanguardasistemas.application.exception.NotFoundException;
import br.com.vanguardasistemas.domain.model.RealEstate;
import br.com.vanguardasistemas.domain.repository.RealEstateRepository;
import br.com.vanguardasistemas.mocks.RealEstateMocks;

@ExtendWith(MockitoExtension.class)
class RealEstateFindByIdUseCaseImplTest {

    @Mock
    private RealEstateRepository realEstateRepository;

    private RealEstateFindByIdUseCaseImpl realEstateFindByIdUseCase;

    @BeforeEach
    void setUp() {
        realEstateFindByIdUseCase = new RealEstateFindByIdUseCaseImpl(realEstateRepository);
    }

    @Test
    void shouldFindRealEstateByIdSuccessfully() {
        UUID realEstateId = RealEstateMocks.REAL_ESTATE_ID;
        RealEstate realEstate = RealEstateMocks.defaultRealEstate(null);

        when(realEstateRepository.findById(realEstateId)).thenReturn(realEstate);

        RealEstate result = realEstateFindByIdUseCase.findById(realEstateId);

        assertNotNull(result);
        assertEquals(realEstate, result);
        assertEquals(realEstateId, result.getRealEstateId());
        assertEquals(RealEstateMocks.PROPERTY_TYPE, result.getPropertyType());
        assertEquals(RealEstateMocks.PROPERTY_NAME, result.getPropertyName());
        assertEquals(RealEstateMocks.DESCRIPTION, result.getDescription());
        assertEquals(RealEstateMocks.TOTAL_AREA_DESCRIPTION, result.getTotalAreaDescription());
        assertEquals(RealEstateMocks.BUILT_AREA_DESCRIPTION, result.getBuiltAreaDescription());
        assertEquals(RealEstateMocks.IDEAL_AREA, result.getIdealArea());
        assertEquals(RealEstateMocks.PROPERTY_REGISTRATION_NUMBER, result.getPropertyRegistrationNumber());
        assertEquals(RealEstateMocks.ADDITIONAL_NOTES, result.getAdditionalNotes());

        verify(realEstateRepository).findById(realEstateId);
    }

    @Test
    void shouldThrowNotFoundExceptionWhenRealEstateNotFound() {
        UUID realEstateId = UUID.randomUUID();
        when(realEstateRepository.findById(realEstateId)).thenReturn(null);

        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            realEstateFindByIdUseCase.findById(realEstateId);
        });

        assertEquals("Record of type 'RealEstate' not found: " + realEstateId, exception.getMessage());
        verify(realEstateRepository).findById(realEstateId);
    }
} 