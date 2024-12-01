package com.nexushub.playground.clock;


import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.mockStatic;

@ExtendWith(MockitoExtension.class)
class WatchOutletFormatterTest {
  private final TestUtil util = new TestUtil();

  private final WatchOutletFormatter watchOutletFormatter = new WatchOutletFormatter();

  @Nested
  class multiInstantTest {
    @Test
    void showTime_FourPasses() {
      // given
      LocalDateTime firstFixed = setFixedTime(1, 5);
      LocalDateTime secondFixed = setFixedTime(1, 10);
      LocalDateTime thirdFixed = setFixedTime(1, 15);
      LocalDateTime fourthFixed = setFixedTime(12, 45);

      try (MockedStatic<LocalDateTime> mockedLocalDateTime = mockStatic(LocalDateTime.class)) {
        // one
        mockedLocalDateTime.when(LocalDateTime::now).thenReturn(firstFixed);

        // when
        String[][] actual1 = watchOutletFormatter.showTime();

        // then
        assertArrayEquals(util.fünfAbEis(), actual1);

        // two
        mockedLocalDateTime.when(LocalDateTime::now).thenReturn(secondFixed);

        // when
        String[][] actual2 = watchOutletFormatter.showTime();

        // then
        assertArrayEquals(util.zääAbEis(), actual2);

        // three
        mockedLocalDateTime.when(LocalDateTime::now).thenReturn(thirdFixed);

        // when
        String[][] actual3 = watchOutletFormatter.showTime();

        // then
        assertArrayEquals(util.viertelAbEis(), actual3);

        // four
        mockedLocalDateTime.when(LocalDateTime::now).thenReturn(fourthFixed);

        // when
        String[][] actual4 = watchOutletFormatter.showTime();

        // then
        assertArrayEquals(util.viertelVorEis(), actual4);
      }
    }
  }

  @Nested
  class singleInstantTest {
    @Test
    void showTime_fünfAbEis() {
      // given
      LocalDateTime fixedDateTime = setFixedTime(1, 5);

      try (MockedStatic<LocalDateTime> mockedLocalDateTime = mockStatic(LocalDateTime.class)) {
        mockedLocalDateTime.when(LocalDateTime::now).thenReturn(fixedDateTime);

        // when
        String[][] actual = watchOutletFormatter.showTime();

        // then
        assertArrayEquals(util.fünfAbEis(), actual);
      }
    }

    @Test
    void showTime_zääAbEis() {
      // given
      LocalDateTime fixedDateTime = setFixedTime(1, 10);

      try (MockedStatic<LocalDateTime> mockedLocalDateTime = mockStatic(LocalDateTime.class)) {
        mockedLocalDateTime.when(LocalDateTime::now).thenReturn(fixedDateTime);

        // when
        String[][] actual = watchOutletFormatter.showTime();

        // then
        assertArrayEquals(util.zääAbEis(), actual);
      }
    }

    @Test
    void showTime_viertelAbEis() {
      // given
      LocalDateTime fixedDateTime = setFixedTime(1, 15);

      try (MockedStatic<LocalDateTime> mockedLocalDateTime = mockStatic(LocalDateTime.class)) {
        mockedLocalDateTime.when(LocalDateTime::now).thenReturn(fixedDateTime);

        // when
        String[][] actual = watchOutletFormatter.showTime();

        // then
        assertArrayEquals(util.viertelAbEis(), actual);
      }
    }

    @Test
    void showTime_zwänzigAbEis() {
      // given
      LocalDateTime fixedDateTime = setFixedTime(1, 20);

      try (MockedStatic<LocalDateTime> mockedLocalDateTime = mockStatic(LocalDateTime.class)) {
        mockedLocalDateTime.when(LocalDateTime::now).thenReturn(fixedDateTime);

        // when
        String[][] actual = watchOutletFormatter.showTime();

        // then
        assertArrayEquals(util.zwänzigAbEis(), actual);
      }
    }

    @Test
    void showTime_fünfAbHalbiEis() {
      // given
      LocalDateTime fixedDateTime = setFixedTime(1, 35);

      try (MockedStatic<LocalDateTime> mockedLocalDateTime = mockStatic(LocalDateTime.class)) {
        mockedLocalDateTime.when(LocalDateTime::now).thenReturn(fixedDateTime);

        // when
        String[][] actual = watchOutletFormatter.showTime();

        // then
        assertArrayEquals(util.fünfAbHalbiEis(), actual);
      }
    }

    @Test
    void showTime_fünfVorEis() {
      // given
      LocalDateTime fixedDateTime = setFixedTime(12, 55);

      try (MockedStatic<LocalDateTime> mockedLocalDateTime = mockStatic(LocalDateTime.class)) {
        mockedLocalDateTime.when(LocalDateTime::now).thenReturn(fixedDateTime);

        // when
        String[][] actual = watchOutletFormatter.showTime();

        // then
        assertArrayEquals(util.fünfVorEis(), actual);
      }
    }

    @Test
    void showTime_zääVorEis() {
      // given
      LocalDateTime fixedDateTime = setFixedTime(12, 50);

      try (MockedStatic<LocalDateTime> mockedLocalDateTime = mockStatic(LocalDateTime.class)) {
        mockedLocalDateTime.when(LocalDateTime::now).thenReturn(fixedDateTime);

        // when
        String[][] actual = watchOutletFormatter.showTime();

        // then
        assertArrayEquals(util.zääVorEis(), actual);
      }
    }

    @Test
    void showTime_viertelVorEis() {
      // given
      LocalDateTime fixedDateTime = setFixedTime(12, 45);

      try (MockedStatic<LocalDateTime> mockedLocalDateTime = mockStatic(LocalDateTime.class)) {
        mockedLocalDateTime.when(LocalDateTime::now).thenReturn(fixedDateTime);

        // when
        String[][] actual = watchOutletFormatter.showTime();

        // then
        assertArrayEquals(util.viertelVorEis(), actual);
      }
    }

    @Test
    void showTime_zwanzigVorEis() {
      // given
      LocalDateTime fixedDateTime = setFixedTime(12, 40);

      try (MockedStatic<LocalDateTime> mockedLocalDateTime = mockStatic(LocalDateTime.class)) {
        mockedLocalDateTime.when(LocalDateTime::now).thenReturn(fixedDateTime);

        // when
        String[][] actual = watchOutletFormatter.showTime();

        // then
        assertArrayEquals(util.zwanzigVorEis(), actual);
      }
    }

    @Test
    void showTime_fünfVorHalbiEis() {
      // given
      LocalDateTime fixedDateTime = setFixedTime(12, 25);

      try (MockedStatic<LocalDateTime> mockedLocalDateTime = mockStatic(LocalDateTime.class)) {
        mockedLocalDateTime.when(LocalDateTime::now).thenReturn(fixedDateTime);

        // when
        String[][] actual = watchOutletFormatter.showTime();

        // then
        assertArrayEquals(util.fünfVorHalbiEis(), actual);
      }
    }
  }

  private LocalDateTime setFixedTime(int hour, int minute) {
    return LocalDateTime.of(2023, 11, 30, hour, minute);
  }
}