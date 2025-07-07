package br.com.vanguardasistemas.adapter.db.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.vanguardasistemas.adapter.entity.ItbiPaymentSlipEntity;
import br.com.vanguardasistemas.adapter.mapper.ItbiPaymentSlipEntityMapper;
import br.com.vanguardasistemas.domain.model.ItbiPaymentSlip;
import br.com.vanguardasistemas.domain.repository.ItbiPaymentSlipRepository;

@Repository
public class ItbiPaymentSlipRepositoryImpl implements ItbiPaymentSlipRepository {

  private final ItbiPaymentSlipJpaRepository itbiPaymentSlipJpaRepository;
  private final ItbiPaymentSlipEntityMapper itbiPaymentSlipEntityMapper;

  public ItbiPaymentSlipRepositoryImpl(
    ItbiPaymentSlipJpaRepository itbiPaymentSlipJpaRepository,
    ItbiPaymentSlipEntityMapper itbiPaymentSlipEntityMapper
  ) {
    this.itbiPaymentSlipJpaRepository = itbiPaymentSlipJpaRepository;
    this.itbiPaymentSlipEntityMapper = itbiPaymentSlipEntityMapper;
  }

  @Override
  public ItbiPaymentSlip save(ItbiPaymentSlip itbiPaymentSlip) {
    ItbiPaymentSlipEntity entity = itbiPaymentSlipEntityMapper.toEntity(itbiPaymentSlip);
    ItbiPaymentSlipEntity saved = itbiPaymentSlipJpaRepository.save(entity);
    return itbiPaymentSlipEntityMapper.toDomain(saved);
  }

  @Override
  public ItbiPaymentSlip findById(UUID id) {
    return itbiPaymentSlipJpaRepository.findById(id)
      .map(itbiPaymentSlipEntityMapper::toDomain)
      .orElse(null);
  }
} 