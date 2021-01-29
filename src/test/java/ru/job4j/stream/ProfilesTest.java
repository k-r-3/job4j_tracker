package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    private List<Profile> listProfiles = new ArrayList<>();

    @Before
    public void setUp() {
        listProfiles.add(
                new Profile(new Address("Novosibirsk", "Lenin",
                24,  12))
        );
        listProfiles.add(
                new Profile(new Address("Novosibirsk", "Lenin",
                        24, 12))
        );
        listProfiles.add(
                new Profile(new Address("Nizhny Novgorod", "Rozhdestvenskaya",
                        57, 1))
        );
        listProfiles.add(
                new Profile(new Address("Oryol", "Lenin",
                        57, 1))
        );

    }

    @Test
    public void whenUniqAddress() {
        Profiles profiles = new Profiles();
        List<Address> input = profiles.uniqAddress(profiles.collect(listProfiles));
        List<Address> expected = new ArrayList<Address>(List.of(
                listProfiles.get(2).getAddress(),
                listProfiles.get(1).getAddress(),
                listProfiles.get(3).getAddress()
        ));
        assertThat(input, is(expected));
    }

}