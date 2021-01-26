package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {

    public static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> cond) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (cond.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static Predicate<Attachment> filterName(Attachment att) {
        Predicate<Attachment> predicateName = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getName().contains(att.getName());
            }
        };
        return predicateName;
    }

        public static Predicate<Attachment> filterSize(Attachment att) {
            Predicate<Attachment> predicateSize = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getSize() > att.getSize();
            }
        };
        return predicateSize;
    }

    public static void main(String[] args) {
        Attachment attSize = new Attachment("", 100);
        Attachment attName = new Attachment("bug", 0);
        List<Attachment> la = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 134),
                new Attachment("image 3", 13),
                new Attachment("bugs", 134)
        );
        List<Attachment> filterAttachment =  filter(la, filterSize(attSize));
        filterAttachment = List.copyOf(filter(filterAttachment, filterName(attName)));
    }
}
