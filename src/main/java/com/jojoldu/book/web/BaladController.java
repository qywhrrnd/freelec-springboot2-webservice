/*
package com.jojoldu.book.web;


import com.jojoldu.book.domain.MusicEntity;
import com.jojoldu.book.dto.TopDto;
import com.jojoldu.book.service.BaladService;
import com.jojoldu.book.service.TopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class BaladController {

    private final BaladService baladService;

    @GetMapping("/balad")
    public String balad(Model model) throws IOException {

        List<MusicEntity> baladDtoList = baladService.getMusicNaver();

        model.addAttribute("baladDto", baladDtoList);

        return "balad";
    }

    @GetMapping("/test")
    public String test(Model model) throws IOException {
        List<MusicEntity> musicEntityList = baladService.getMusicNaver();
        model.addAttribute("musicList", musicEntityList);
        return "test";
    }


}
*/
