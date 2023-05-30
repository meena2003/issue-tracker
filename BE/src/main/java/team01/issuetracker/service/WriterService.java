package team01.issuetracker.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team01.issuetracker.repository.MemberRepository;
import team01.issuetracker.service.dto.response.WriterDTO;
import team01.issuetracker.service.dto.response.WritersResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WriterService {
    @Autowired
    private MemberRepository memberRepository;

    public WritersResponseDTO getWriters() {
        List<WriterDTO> writers = memberRepository.findAll().stream()
                .map(WriterDTO::of)
                .collect(Collectors.toList());

        return WritersResponseDTO.builder()
                .writers(writers)
                .build();
    }
}

