package com.rest.account.mapper;

import com.rest.account.entity.AccountEntity;
import com.rest.account.model.AccountDto;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.NullValueMappingStrategy.RETURN_DEFAULT;
import static org.mapstruct.ReportingPolicy.IGNORE;
import static org.mapstruct.factory.Mappers.getMapper;

@Mapper(componentModel = "spring", nullValueMappingStrategy = RETURN_DEFAULT, unmappedTargetPolicy = IGNORE)
public interface AccountMapper {

    AccountMapper INSTANCE = getMapper(AccountMapper.class);
    AccountDto toAccountDto(AccountEntity accountEntity);
    List<AccountDto> toAccountDtoList(List<AccountEntity> accountEntities);
}
