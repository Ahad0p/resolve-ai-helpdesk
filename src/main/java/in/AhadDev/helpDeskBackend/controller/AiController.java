package in.AhadDev.helpDeskBackend.controller;

import in.AhadDev.helpDeskBackend.service.AiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/ai")
@RequiredArgsConstructor
public class AiController {

    private final AiService aiService;

    @PostMapping
    public ResponseEntity<String> chat(@RequestBody String query,
                                       @RequestHeader("ConversationId") String conversationId) {
        return ResponseEntity.ok(aiService.getResponseFromAssistant(query,conversationId));
    }

    @PostMapping(value = "/stream")
    public Flux<String> streamResponse(@RequestBody  String query, @RequestHeader("ConversationId") String conversationId){
        return aiService.streamResponseFromAssistant(query,conversationId) ;
    }
}
