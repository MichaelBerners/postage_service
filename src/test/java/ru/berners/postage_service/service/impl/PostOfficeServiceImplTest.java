package ru.berners.postage_service.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.berners.postage_service.domain.entity.PostOffice;
import ru.berners.postage_service.domain.exception.PostOfficeNotFound;
import ru.berners.postage_service.domain.mapper.PostOfficeRespMapper;
import ru.berners.postage_service.domain.repository.PostOfficeRepository;
import ru.berners.postage_service.domain.request.PostOfficeRequest;
import ru.berners.postage_service.domain.response.PostOfficeResponse;
import ru.berners.postage_service.service.impl.PostOfficeServiceImpl;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class PostOfficeServiceImplTest {
    @InjectMocks
    PostOfficeServiceImpl service;
    @Mock
    PostOfficeRepository postOfficeRepository;
    @Spy
    PostOfficeRespMapper postOfficeRespMapper = Mappers.getMapper(PostOfficeRespMapper.class);
    @Captor
    ArgumentCaptor<PostOffice> postOfficeArgumentCaptor;

    @Test
    void create() {
        PostOfficeRequest postOfficeRequest = new PostOfficeRequest();
        postOfficeRequest.setAddress("adddress");
        postOfficeRequest.setName("name");
        postOfficeRequest.setIndex("123123");
        Mockito.when(postOfficeRepository.findByIndex(postOfficeRequest.getIndex())).thenReturn(Optional.empty());
        Mockito.when(postOfficeRepository.save(postOfficeArgumentCaptor.capture())).thenAnswer(e -> e.getArgument(0));

        PostOfficeResponse result = service.create(postOfficeRequest);

        Assertions.assertThat(result)
                .isNotNull()
                .usingRecursiveComparison()
                .isEqualTo(postOfficeRequest);
        Mockito.verify(postOfficeRepository).save(Mockito.any());
        Assertions.assertThat(postOfficeArgumentCaptor.getValue())
                .matches(e -> e.getIndex().equals(postOfficeRequest.getIndex()))
                .matches(e -> e.getName().equals(postOfficeRequest.getName()))
                .matches(e -> e.getAddress().equals(postOfficeRequest.getAddress()));
    }

    @Test
    void read_case1() {
        String index = "123123";
        PostOffice postOffice = new PostOffice();
        postOffice.setIndex(index);
        postOffice.setName("name");
        Mockito.when(postOfficeRepository.findByIndex(index)).thenReturn(Optional.of(postOffice));

        PostOffice result = service.read(index);

        Assertions.assertThat(result)
                .isNotNull()
                .isEqualTo(postOffice);
    }

    @Test
    void read_case2() {
        String index = "123123";
        Mockito.when(postOfficeRepository.findByIndex(index)).thenReturn(Optional.empty());

        Assertions.assertThatThrownBy(() -> service.read(index))
                .isInstanceOf(PostOfficeNotFound.class);
    }
}
