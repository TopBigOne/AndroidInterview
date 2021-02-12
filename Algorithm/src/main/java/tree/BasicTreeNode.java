package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author : dev
 * @version :
 * @Date :  2/12/21 5:03 PM
 * @Desc :
 */

public abstract class BasicTreeNode<T> {
    public static final int TWO = 2;
    public T val;

    public BasicTreeNode(T val) {
        this.val = val;
    }

    /**
     * 左子树
     *
     * @return
     */
    public abstract BasicTreeNode<T> left();

    /**
     * 右子树
     *
     * @return
     */
    public abstract BasicTreeNode<T> right();


    protected String nodeValToStr() {
        return val.toString();
    }

    @Override
    public String toString() {
        List<PositionChar> chars = toPositionChars();
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        Map<Integer, Integer> integerHashMap = new HashMap<>(16);
        for (PositionChar item : chars) {
            if (item.x < minX) {
                minX = item.x;
            }
            if (item.x > maxX) {
                maxX = item.x;
            }
            if (item.y > maxY) {
                maxY = item.y;
            }

            if (integerHashMap.containsKey(item.y)) {
                int cur = integerHashMap.get(item.y);
                if (cur < item.x) {
                    integerHashMap.put(item.y, item.x);
                }
            } else {
                integerHashMap.put(item.y, item.x);
            }
        }
        int xLen = maxX - minX + 1;
        int offsetX = -minX;
        char[][] charArr = new char[maxY + 1][xLen + 1];

        Set<Map.Entry<Integer, Integer>> keyVals = integerHashMap.entrySet();
        for (Map.Entry<Integer, Integer> keyVal : keyVals) {
            charArr[keyVal.getKey()][keyVal.getValue() + offsetX + 1] = '\n';
        }

        for (PositionChar item : chars) {
            charArr[item.y][item.x + offsetX] = item.c;
        }
        StringBuilder strBld = new StringBuilder();
        strBld.append('\n');
        for (int i = 0; i <= maxY; i++) {
            for (int j = 0; j <= xLen; j++) {
                char c = charArr[i][j];
                if (c == '\n') {
                    strBld.append('\n');
                    break;
                } else if (c == '\0') {
                    strBld.append(' ');
                } else {
                    strBld.append(c);
                }
            }
        }
        return strBld.toString();
    }


    private List<PositionChar> toPositionChars() {
        List<PositionChar> result = new ArrayList<>();
        String valStr = nodeValToStr();
        int valStrLen = valStr.length();
        int offset = 0;
        if (left() != null || right() != null) {
            List<PositionChar> leftChars = null;
            List<PositionChar> rightChars = null;
            Map<Integer, Integer> leftMax = new HashMap<>(16);
            Map<Integer, Integer> rightMin = new HashMap<>(16);
            if (left() != null) {
                leftChars = left().toPositionChars();
                int leftOffset = left().nodeValToStr().length() + 1;
                for (PositionChar item : leftChars) {
                    item.x -= leftOffset;
                    item.y += 2;
                    if (leftMax.containsKey(item.y)) {
                        leftMax.put(item.y, Math.max(item.x, leftMax.get(item.y)));
                    } else {
                        leftMax.put(item.y, item.x);
                    }
                }
                if (leftMax.containsKey(TWO)) {
                    leftChars.add(new PositionChar(leftMax.get(2) + 1, 1, '/'));
                    leftMax.put(1, leftMax.get(2) + 1);
                }
            }
            if (right() != null) {
                rightChars = right().toPositionChars();
                int rightOffset = valStrLen + 1;
                for (PositionChar item : rightChars) {
                    item.x += rightOffset;
                    item.y += 2;
                    if (rightMin.containsKey(item.y)) {
                        rightMin.put(item.y, Math.min(item.x, rightMin.get(item.y)));
                    } else {
                        rightMin.put(item.y, item.x);
                    }
                }
                if (rightMin.containsKey(TWO)) {
                    rightChars.add(new PositionChar(rightMin.get(2) - 1, 1, '\\'));
                    rightMin.put(1, rightMin.get(2) - 1);
                }
            }

            if (leftChars != null && rightChars != null) {
                boolean isCrossing;
                do {
                    isCrossing = false;
                    Set<Integer> keys = leftMax.keySet();
                    for (Integer key : keys) {
                        if (rightMin.containsKey(key) && leftMax.get(key) + 2 > rightMin.get(key) + offset) {
                            isCrossing = true;
                            break;
                        }
                    }

                    if (isCrossing) {
                        offset += 1;
                    }
                }
                while (isCrossing);

                for (PositionChar item : rightChars) {
                    item.x += offset;
                }
            }

            if (leftChars != null) {
                result.addAll(leftChars);
            }
            if (rightChars != null) {
                result.addAll(rightChars);
            }
        }
        for (int i = 0, len = valStr.length(); i < len; i++) {
            result.add(new PositionChar(i + (int) (offset / 2.0 + 0.5), 0, valStr.charAt(i)));
        }
        return result;
    }

    private static class PositionChar {
        public int x;
        public int y;
        public char c;

        public PositionChar(int x, int y, char c) {
            this.c = c;
            this.x = x;
            this.y = y;
        }
    }

}