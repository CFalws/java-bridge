package bridge.service;

import bridge.BridgeMaker;
import bridge.model.Bridge;
import bridge.model.GameStatus;
import bridge.model.Moving;
import bridge.model.Player;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeMaker bridgeMaker;
    private Bridge bridge;
    private GameStatus gameStatus;

    public BridgeGame(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }

    public void initialize() {
        gameStatus = GameStatus.PLAY;
    }

    public void makeBridge(int bridgeSize) {
        bridge = bridgeMaker.makeBridge(bridgeSize).stream()
                .map(Moving::valueOf)
                .collect(collectingAndThen(toList(), Bridge::new));
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Player player, Moving moving) {
        player.move(moving, bridge);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
