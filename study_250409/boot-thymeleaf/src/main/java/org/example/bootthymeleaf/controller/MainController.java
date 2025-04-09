package org.example.bootthymeleaf.controller;

import lombok.RequiredArgsConstructor;
import org.example.bootthymeleaf.model.dto.WordForm;
import org.example.bootthymeleaf.model.entity.Word;
import org.example.bootthymeleaf.model.repository.WordRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final WordRepository wordRepository;

    @GetMapping
    public String index(Model model, @RequestParam(required = false) String message) {
//        Word word = new Word();
//        word.setText("고양이");
//        wordRepository.save(word);
        List<Word> data = wordRepository.findAllByOrderByCreatedAtAsc();
        model.addAttribute("data", data);
        model.addAttribute("wordForm", new WordForm());
        return "index";
    }

    @PostMapping("/word")
    public String addWord(WordForm wordForm, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message", "끝말잇기 추가");
        Word word = new Word();
        word.setText(wordForm.getWord());
        wordRepository.save(word);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteWord(@RequestParam("id") String uuid, RedirectAttributes redirectAttributes) {
        wordRepository.deleteById(uuid);
        redirectAttributes.addFlashAttribute("message", "삭제 되었습니다.");
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateWord(@RequestParam("id") String uuid, @RequestParam("text") String text, RedirectAttributes redirectAttributes) {
        Optional<Word> wordOptional = wordRepository.findById(uuid);
        Word word = wordOptional.get();
        word.setText(text);
        wordRepository.save(word);
        redirectAttributes.addFlashAttribute("message", "수정 되었습니다. %s".formatted(uuid));
        return "redirect:/";
    }

    @PostMapping("/reset")
    public String resetWord(RedirectAttributes redirectAttributes) {
        wordRepository.deleteAll();
        redirectAttributes.addFlashAttribute("message", "전체 삭제되었습니다.");
        return "redirect:/";
    }
}
