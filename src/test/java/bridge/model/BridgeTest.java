package bridge.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {
    Bridge bridge = new Bridge(List.of(Moving.U, Moving.U, Moving.D));

    @ParameterizedTest(name = "{0} 위치의 {1} 칸 선택하면 플레이어는 {2}가 된다.")
    @CsvSource({"0,U,MOVING", "1,D,DEAD", "2,D,CROSSED"})
    void acceptPlayer_메서드는_Player의_위치와_이동할_칸을_입력받고_PlayerStatus를_반환한다(int location, Moving choice, PlayerStatus expected) {
        assertThat(bridge.acceptPlayer(location, choice)).isEqualTo(expected);
    }
}