package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    Comparator<Address> addressComparator = Comparator.comparing(Address::getCity);

    List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }

    List<Address> uniqAddress(List<Address> addresses) {
        List<Address> result = addresses.stream()
                .sorted(addressComparator)
                .distinct()
                .collect(Collectors.toList());
        return result;
    }
}
