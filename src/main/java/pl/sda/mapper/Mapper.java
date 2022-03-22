package pl.sda.mapper;

public interface Mapper<T, U> {

    T mapEntityToDto(U entityObject);

    U mapDtoToEntity(T dtoObject);
}
