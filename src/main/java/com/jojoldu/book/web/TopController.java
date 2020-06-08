package com.jojoldu.book.web;


import com.jojoldu.book.domain.MusicEntity;
import com.jojoldu.book.dto.TopDto;
import com.jojoldu.book.service.TopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class TopController {

    private final TopService topService;

    @GetMapping("/top")
    public String top(Model model) throws IOException {

        List<MusicEntity> topDtoList = topService.getMusicNaver();

        model.addAttribute("topDto", topDtoList);

        return "top";
    }

    @GetMapping("/test")
    public String test(Model model) throws IOException {
        List<MusicEntity> musicEntityList = topService.getMusicNaver();
        model.addAttribute("musicList", musicEntityList);
        return "test";
    }


}
