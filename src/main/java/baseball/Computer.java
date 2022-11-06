package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Computer {
    private final String STRIKE = "스트라이크";
    private final String BALL = "볼";
    private final String NOTHING = "낫싱";
    private int strikeCount = 0;
    private int ballCount = 0;
    private Number numFactory;
    private List<Integer> computerNumber;
    public Computer() {
        numFactory = new ComputerNum();
        computerNumber = numFactory.createNumber();
        numFactory.verifyNumber(computerNumber);
    }

    public void calculateCount(int i, List<Integer> playerNumber) {
        if (computerNumber.contains(playerNumber.get(i))) {
            if (computerNumber.indexOf(playerNumber.get(i)) == i)
                strikeCount++;
            else
                ballCount++;
        }
    }

    public String getResult(List<Integer> playerNumber) {
        resetCount();
        for (int i = 0; i < 3; i++) {
            calculateCount(i, playerNumber);
        }

        if (strikeCount == 3) {
            System.out.println("3" + STRIKE);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return "3스트라이크";
        } else if (ballCount < 1 && strikeCount < 1)
            System.out.println(NOTHING);
        else if (strikeCount < 1)
            System.out.println(ballCount + BALL);
        else if (ballCount < 1)
            System.out.println(strikeCount + STRIKE);
        else
            System.out.println(ballCount + BALL  +" "+ strikeCount + STRIKE);
        return "아직 게임이 진행중 입니다";
    }

    public boolean closeGame() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        return getStatusByInput(input);
    }

    public boolean getStatusByInput(String input) {
        if (input.equals("1")) {
            return true;
        } else if (input.equals("2"))
            return false;
        else
            throw new IllegalArgumentException();
    }


    public void resetCount() {
        strikeCount = 0;
        ballCount = 0;
    }

}
