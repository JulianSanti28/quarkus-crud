package co.unicauca.example.exception.mapper;

import co.unicauca.example.domain.ResponseDto;
import co.unicauca.example.exception.BaseException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class BusinessRuleExceptionMapper implements ExceptionMapper<BaseException> {
    @Override
    public Response toResponse(BaseException e) {
        return new ResponseDto<>(e.getStatus(), e.getMessage(), e.getErrorCode()).of();
    }
}
