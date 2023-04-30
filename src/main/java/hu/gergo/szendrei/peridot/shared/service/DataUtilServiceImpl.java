package hu.gergo.szendrei.peridot.shared.service;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import hu.gergo.szendrei.peridot.shared.exception.dto.CustomRuntimeExceptionDto;

@Component
public class DataUtilServiceImpl implements DataUtilService {
    @Override
    public String getResource(String path) {
        try {
            return new ClassPathResource(path).getContentAsString(Charset.defaultCharset());
        } catch (IOException e) {
            throw new CustomRuntimeExceptionDto("Resource - getContentAsString", e);
        }
    }
}
