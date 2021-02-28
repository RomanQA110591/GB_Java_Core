package ru.GB.Lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class University {

    static class Unic {

        enum Position {
            UNICAL, NEUNICAL;
        }

        private String nameStudens;
        private String nameCurs;
        private Position position;

        public Unic(String nameStudens, String nameCurs, Position position) {
            this.nameStudens = nameStudens;
            this.nameCurs = nameCurs;
            this.position = position;
        }

        public String getNameCurs() {
            return nameCurs;
        }
    }

    private static void streamSimpleTask() {
        List<Unic> unics = new ArrayList<>(Arrays.asList(
                new Unic("Bob1", "QA", Unic.Position.NEUNICAL),
                new Unic("Bob2", "Biologia", Unic.Position.UNICAL),
                new Unic("Bob3", "QA", Unic.Position.UNICAL),
                new Unic("Bob1", "Progam", Unic.Position.UNICAL),
                new Unic("Bob2", "Analiz", Unic.Position.NEUNICAL),
                new Unic("Bob3", "Analiz", Unic.Position.UNICAL),
                new Unic("Bob1", "Biologia", Unic.Position.UNICAL),
                new Unic("Bob2", "Progam", Unic.Position.NEUNICAL),
                new Unic("Bob3", "Progam", Unic.Position.UNICAL)
        ));


        List<String> engineersNames = unics.stream()
                .filter(unic -> unic.position == Unic.Position.UNICAL)
                .map((Function<Unic, String>) unic -> unic.nameStudens)
                .collect(Collectors.toList());
        System.out.println(engineersNames);
    }


    public static void main(String[] args) {
        streamSimpleTask();
    }

}

