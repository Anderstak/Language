package com.onegin.language.dictionary;

import com.onegin.language.dictionary.entities.Definition;
import com.onegin.language.dictionary.entities.PartOfSpeech;
import com.onegin.language.dictionary.entities.WordDefinition;

import java.util.SortedMap;
import java.util.TreeMap;

public class DictionaryService {

    private SortedMap<String, Definition> dictionary;

    // Это конструктор.
    // Он отвечает за то, чтобы подготовить сервис к работе
    // Пока у нас нет баз данных или мест, откуда брать данные
    // Поэтому мы пока сделаем заглушку
    public DictionaryService() {
        this.dictionary = new TreeMap<>();

        dictionary.put("яблоко", new Definition("яблоко")
                .addDefinition(
                        new WordDefinition(PartOfSpeech.Noun, "плод яблони")
                )
                .addDefinition(
                        new WordDefinition(PartOfSpeech.Noun, "устройство фирмы Apple")
                )
        );

        dictionary.put("радость", new Definition("радость")
                .addDefinition(
                        new WordDefinition(PartOfSpeech.Noun, "Чувство удовольствия, ощущение большого душевного удовлетворения.")
                )
                .addDefinition(
                        new WordDefinition(PartOfSpeech.Noun, "То, что (тот, кто) доставляет удовольствие, даёт счастье.")
                )
                .addDefinition(
                        new WordDefinition(PartOfSpeech.Noun, "Ласковое, нежное обращение.")
                )
        );

    }

    public SortedMap<String, Definition> getAllDefinitions() {
        return this.dictionary;
    }

    public Definition getDefinition(String word) {
        return this.dictionary.get(word);
    }

}
