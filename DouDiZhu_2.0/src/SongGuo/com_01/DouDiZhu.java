package SongGuo.com_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/*步骤：
 * 
 * 1.创建编号和牌对应的map集合
 * 
 * 2.准备一副牌（54个数字1——54）
 * 
 * 3.洗牌
 * 
 * 4.发牌
 * 
 * 5.排序
 * 
 * 6.从map集合查找
 * 
 * 7.看牌
 * 
 */

public class DouDiZhu {

	public static void main(String[] args) {
		// 创建编号和牌对应的map集合
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		// prepare cards (1-54)
		ArrayList<Integer> cards = new ArrayList<Integer>();

		// 向map中添加数据
		int id = 1;
		String[] colors = { "♠", "♥", "♣", "♦" };
		String[] nums = { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2" };
		// make cards

		for (String num : nums) {
			for (String color : colors) {
				String card = color + num;
				map.put(id, card);
				cards.add(id);
				id++;
			}
		}
		// King
		map.put(id, "大王");
		cards.add(id);
		id++;
		map.put(id, "小王");
		cards.add(id);

		// 3.wash cards
		Collections.shuffle(cards);
		// 4.playing cards

		ArrayList<Integer> p1 = new ArrayList<Integer>();
		ArrayList<Integer> p2 = new ArrayList<Integer>();
		ArrayList<Integer> p3 = new ArrayList<Integer>();
		ArrayList<Integer> p4 = new ArrayList<Integer>();
		// xunhuan cards
		for (int i = 0; i < cards.size(); i++) {
			Integer card = cards.get(i);

			if (i >= 51) {
				p4.add(card);
			} else {
				if (i % 3 == 0) {
					p1.add(card);
				} else if (i % 3 == 1) {
					p2.add(card);
				} else {
					p3.add(card);
				}
			}
		}
		// 5.paixu
		Collections.sort(p1);
		Collections.sort(p2);
		Collections.sort(p3);
		Collections.sort(p4);

		// 6.print
		lookCards(p1,map);
		lookCards(p2,map);
		lookCards(p3,map);
		lookCards(p4,map);
		 
	}

	private static void lookCards(ArrayList<Integer> p, Map<Integer, String> map) {
		// TODO Auto-generated method stub
		// 从map集合中查询对应的牌
		for (Integer cardid : p ) {
			String card = map.get(cardid);
			System.out.print(card+" ");
		}
		System.out.println();
	}

}
