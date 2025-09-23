package it.apuliadigital.consumer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A tiny read API so students can check what's been persisted.
 */
@RestController
@RequestMapping("/api/stored")
public class StoredMessageController {
}
