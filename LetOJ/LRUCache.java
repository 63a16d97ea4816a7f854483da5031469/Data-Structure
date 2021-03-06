package ok;

/*
 * 
 * https://leetcode.com/problems/lru-cache/

Design and implement a data structure for Least Recently Used (LRU) cache. 
It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key 
if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is 
not already present. When the cache reached its capacity, 
it should invalidate the least recently used item before inserting a new item.

public class LRUCache {
    
    public LRUCache(int capacity) {
        
    }
    
    public int get(int key) {
        
    }
    
    public void set(int key, int value) {
        
    }
}

5 November 2015 at 5:22:30 pm

 */

import java.util.*;
 

class Node {

	int key;
	int value;

	Node prev;
	Node next;

	Node(int key, int value) {
		this.key = key;
		this.value = value;
	}

}

 public class LRUCache {

	public static void main(String args[]) {

		// 2,[set(2,1),set(1,1),get(2),set(4,1),get(1),get(2)]
		// 1,[set(2,1),get(2),set(3,2),get(2),get(3)]

		// 2,[set(2,1),set(1,1),set(2,3),set(4,1),get(1),get(2)]

		LRUCache lru = new LRUCache(2);
		lru.set(2, 1);
		lru.set(1,1);
		lru.loopList();
		System.out.println("get " + lru.get(2));
		lru.loopList();
		lru.set(4,1);

		System.out.println("get " + lru.get(1));
		System.out.println("get " + lru.get(2));
		lru.loopList();

//		lru.set(2, 3);
//		lru.set(4, 1);
//		lru.loopList();

//		System.out.println("get " + lru.get(2));
		// lru.loopList();
//		lru.loopList();
		// lru.loopList();
		// lru.set(4, 1);
		// lru.loopList();
		// System.out.println("get "+lru.get(1));
		// System.out.println("get "+lru.get(2));
		// lru.loopList();
	}
	

	
	
	/*
	 * Accepted:
	 * 
	 */
	
	/*
	 * 
Tried Two times:

Input:
1,[set(2,1),get(2),set(3,2),get(2),get(3)]
Output:
[1,1,2]
Expected:
[1,-1,2]

2,[set(2,1),set(1,1),get(2),set(4,1),get(1),get(2)]
Output:
[1,1,-1]
Expected:
[1,-1,1]

	 * 
	 */
	
	
	
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
 

	int capacity = 0;

	Node head = null;
	Node rear = null;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}
	
	public int get(int key) {
     
    	if(map.get(key)!=null) {
    		remove(map.get(key));
    		setHead(map.get(key));
    		return map.get(key).value;
    	}
    	
    	return -1;
    }

	public void set(int key, int value) {
		
		   if(map.get(key)!=null){
			 Node tmpNode=map.get(key);
			 tmpNode.value=value;
			 
			 /*
			  *  set it to the head
			  */
			 remove(tmpNode);
			 setHead(tmpNode);
		   }else{

			   Node newNode=new Node(key,value);
			   
			   //add this new key and value into the HashMap
			   map.put(key, newNode);
			   
			   if(map.size()<=capacity){
				   setHead(newNode);
			   }else{
				   removeRear();
				   setHead(newNode);
			   }
 
		   }
	}
	
	public void setHead(Node node){
		
		/*
		 * 1. remove the element from LinkedList
		 * 
		 * Cannot put remove element from LinkedList here:
		 * This method will be called by two different cases:
		 * (1) add totally new node into the list
		 * (2) adjust the old node's position in the list.
		 * 
		 * So we need to use a separated method to handle this.
		 * 
		 * 
		 */
		
		//if this node is  head, no need to do the "set head operation"
		if(node==head) return;
//		
//		
//		if(node.prev!=null) node.prev.next=node.next;
//		
//		if(node.next!=null) node.next.prev=node.prev;
		

		
        /*
 		 * 2. move it to the head.
		 *   (1) head==null
		 *   (2) head!=null		
         */
		if(head==null) {
			head=node;
			rear=head;
		}else{
			node.prev=null;
			head.prev=node;
			node.next=head;
			head=node;
		}
		

		
 
	}
	
	
	public void remove(Node node){
		/*
		 * For removing node, there are several cases:
		 * 
		 * remove from the head
		 * remove from the rear
		 * 
		 * remove from middle
		 * 
		 * 		
		 */
		
		// Consider two directions:
		// from the next direction
		if(node.next!=null){
			

			
			if(node.prev!=null){			

			}
			//if node.preve==null, that means it is head, adjust the head pointer			
			else{
				head=node.next;
			}
			
			node.next.prev=node.prev;
//			
			
			//if node.next==null, that means it is rear. adjust the rear pointer.
		}else{
			
			rear=node.prev;
			
			if(node.prev!=null){
			node.prev.next=null;
			}
			//node.prev==null, it is head.
			else{
				head=null;
				rear=null;
			}
 
		}
		
		
	  // Consider another direction:
	  // from the another direction:
		
		
		if(node.prev!=null){
			
			if(node.next!=null){
				
			}
			//if node.next==null, it means it is rear. need to adjust the rear pointer
			else{
				rear=node.prev;
			}
			
			node.prev.next=node.next;
			
		}
		//if node.prev==null, that means it is head, need to adjust the head pointer
		else{
			
			head=node.next;
			
			if(node.next!=null){
				head.prev=null;
				
			//node.next==null, it is rear.	
			}else{
				head=null;
				rear=null;
			}
		}
		
		
		
		
		
	}
	
	
	
	public void removeRear(){
				
		/*
		 * 1. remove the element from HashMap

		 * 
		 * 
		 */
		
		/*
		 *  Important!!!!:
 public V remove(Object key) {
        Entry<K,V> e = removeEntryForKey(key);
        return (e == null ? null : e.value);
    }

		 * 
		 */
//		map.remove(rear);  // This is wrong.   should put key there.
		
		map.remove(rear.key);
		
//		System.out.println("remove:"+rear.key);
//		System.out.println(map.keySet());
		
		/*
		 * 2. adjust the pointer
		 * 	(1) rear ==null
		 *  (2) rear !=null
		 */
		if(rear==null) {
			head=rear;
		}else{
			rear=rear.prev;
			
			/*
			 * After you delete the last element:
			 * (1) There are more than one elements are left.
			 * (2) There is only one element left.  ---> no need to adjust the head pointer
			 * (3) There is no element left ---> need to adjust the head pointer.
			 * 
			 */
			
		    // (1) There are more than one elements are left.
			if(rear!=null)	{
				rear.next=null;
			
			// (3) There is no element left ---> need to adjust the head pointer.
			}else{
				head=rear;
			}
		}
		
		
	}
	
	public void loopList() {

		Node tmp=head;
		System.out.println("loop list:");
 
		while(tmp!=null){
			System.out.println("Key:" + tmp.key + " Value:" + tmp.value);
			tmp=tmp.next;
		}
		System.out.println("head:"+head.key+" end:"+rear.key);
 
	}	
	
	
	
	
	
	
	
	
	/*
	 * Time Exceed Limted
	 * 
	 * Last executed input:
	2048,..............................................
	
	Reason:
	
	Used the LinkedList to handle, it is not fast enough.
	 * 
	 * 
	 */
	
//	
//	
//	
//
//	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
//	LinkedList<Node> list = new LinkedList<Node>();
//
//	int capacity = 0;
//
//
//	public LRUCache(int capacity) {
//		this.capacity = capacity;
//	}
//
//	public int get(int key) {
//     
//    	if(map.get(key)!=null) {
//    		list.remove(map.get(key));
//    		list.addFirst(map.get(key));
//    		return map.get(key).value;
//    	}
//    	
//    	return -1;
//    }
//
//	public void set(int key, int value) {
//		   if(map.get(key)!=null){
//			 Node tmpNode=map.get(key);
//			 tmpNode.value=value;
//			 //setHead
//			 list.remove(tmpNode);
//			 list.addFirst(tmpNode);
//		   }else{
//			   
//
//			   
//			   Node newNode=new Node(key,value);
//			   
//			   //add this new key and value into the HashMap
//			   map.put(key, newNode);
//			   
//			   if(list.size()<capacity){
//				   list.addFirst(newNode);
//			   }else{
//				   list.removeLast();
//				   list.addFirst(newNode);
//			   }
// 
//		   }
//	}
//	
//	public void loopList() {
//
// 
//		System.out.println("loop list:");
//		for(Node tmp:list){
//
//			System.out.println("Key:" + tmp.key + " Value:" + tmp.value);
//		}
// 
// 
//	}

	/*
	 * 
	 * It should support the following operations: get and set.
	 * 
	 * get(key) - Get the value (will always be positive) of the key if the key
	 * exists in the cache, otherwise return -1. set(key, value) - Set or insert
	 * the value if the key is not already present. When the cache reached its
	 * capacity, it should invalidate the least recently used item before
	 * inserting a new item.
	 * 
	 * 
	 * Thinking: Could we use the existing LinkedList of Java?
	 * 
	 * 
	 */

	// LinkedList<Integer> list=new LinkedList<Integer>();
	/*
	 * we cannot use it, as when we want to remove element, we cannot get the
	 * right position of that specific element. As LinkedList's remove method
	 * only will search the first found element and remove it.
	 * 
	 */

	/*
	 * 
	 * Status: Time Limit Exceeded
	 * 
	 * Last executed input:
	 * 1101,[set(253,668),set(202,206),set(1231,3177),get(465),get(1333),set(651
	 * ,3249),set(453,2472),get(1050),set(145,881),set(1256,1320),set(342,1528),
	 * get(37),set(280,2814),get(11),set(878,903),set(1278,2808),set(942,3238),
	 * set(397,57),set(89,305),set(998,1703),set(1386,1660),set(250,2904),get(
	 * 865),set(21,639),set(1153,751),set(682,3156),set(1246,2932),set(1347,2057
	 * ),set(955,1432),set(1092,3132),set(559,340),set(998,122),set(94,2562),set
	 * (194,1349),set(643,1808),set(905,2449),set(1361,607),set(1374,715),get(
	 * 1052),get(535),get(1122),set(88,137),get(732),set(81,2229),set(219,3241),
	 * get(501),get(1128),set(1006,2187),set(418,1497),get(653),get(170),set(39,
	 * 1072),get(1080),get(1274),set(274,2),get(1289),set(1086,2655),set(647,
	 * 1951),set(1216,2505),get(1119),get(724),get(1279),set(534,955),set(792,
	 * 1351),set(711,1345),get(719),set(939,2615),set(695,2471),set(3,962),get(
	 * 694),set(399,1117),set(837,3074),set(937,252),set(499,2517),get(172),get(
	 * 366),get(166),set(591,3022),set(1384,569),set(1181,1727),get(387),set(832
	 * ,1386),get(1013),get(994),set(496,1320),get(208),set(1186,2479),get(1092)
	 * ,get(1147),set(313,3153),get(710),get(716),get(1353),get(109),set(1220,
	 * 1526),set(1269,2918),set(768,253),set(1080,385),get(623),get(465),set(
	 * 1431,2720),set(421,934),set(943,1794),get(577),get(737),get(213),set(73,
	 * 2109),set(1135,2295),set(899,2812),get(544),set(833,1738),set(1007,2741),
	 * get(115),set(787,1541),set(838,175),get(808),get(76),get(1258),get(129),
	 * set(792,1352),get(401),get(1206),set(1265,3261),set(1234,786),get(1050),
	 * get(994),set(644,1645),set(320,1015),set(449,1254),set(525,880),set(499,
	 * 2711),set(1140,579),set(624,2493),set(547,2502),set(1296,1389),set(465,
	 * 2699),get(737),get(112),set(151,2352),set(525,533),get(732),set(574,2091)
	 * ,set(1124,2645),get(766),get(79),get(877),set(873,2238),get(1250),set(
	 * 1109,453),set(796,1600),get(1095),set(540,1800),get(1429),set(409,1288),
	 * set(959,1555),set(401,1945),set(678,1850),set(674,2882),get(64),get(1245)
	 * ,get(1201),set(184,2814),get(649),set(699,2440),set(767,492),set(211,1386
	 * ),set(1247,1951),set(921,904),set(1185,2528),set(727,450),set(583,1540),
	 * get(207),get(1205),get(745),set(252,1765),set(707,242),set(64,1462),get(
	 * 957),set(1071,2116),set(1319,1053),get(236),set(798,2781),get(570),get(
	 * 295),set(1340,2681),get(136),set(168,1650),set(1128,3109),get(688),set(
	 * 1192,784),set(401,1047),set(797,2219),get(233),get(1186),get(91),set(512,
	 * 1653),get(1288),get(1424),set(321,2992),set(257,2032),get(787),set(332,
	 * 1587),set(510,700),set(896,1710),get(850),set(85,621),get(732),get(113),
	 * set(754,2951),set(134,902),get(1250),set(927,1244),set(1248,40),set(441,
	 * 1078),set(1304,2908),get(1286),get(79),set(220,2207),set(47,528),get(835)
	 * ,set(1387,1855),set(736,704),set(669,1932),get(208),set(3,866),get(1363),
	 * get(1213),get(213),set(1421,1173),set(1423,932),set(1427,664),set(1143,
	 * 2247),set(362,1730),set(9,1226),get(898),set(115,3264),set(1172,1706),set
	 * (39,185),set(784,728),get(1150),set(926,298),set(58,583),get(1242),get(
	 * 1115),set(363,2338),set(1241,2596),get(1148),get(198),set(742,2135),set(
	 * 430,1089),set(1192,3104),set(583,419),set(1101,1930),set(617,1926),get(
	 * 1286),set(324,1488),get(1321),set(76,2881),set(1243,2711),get(1415),get(
	 * 467),get(103),set(687,1236),get(1198),get(1346),get(760),set(945,554),set
	 * (1195,1002),set(212,1565),set(506,2242),set(534,2949),get(63),get(845),
	 * get(899),set(754,876),set(1076,2403),set(677,3117),get(1168),set(1274,606
	 * ),get(997),set(976,1001),get(1179),set(363,1560),set(448,1751),set(511,
	 * 788),set(607,2172),set(863,236),set(616,1954),get(45),set(261,2260),set(
	 * 169,1025),get(159),set(111,2522),get(1063),set(623,383),get(826),set(969,
	 * 2266),set(1222,3158),set(83,658),get(1050),get(718),set(451,1726),set(25,
	 * 644),get(1354),set(1266,2120),set(926,905),get(841),set(1033,725),get(818
	 * ),get(170),get(638),get(708),get(174),set(909,1170),set(159,2824),get(575
	 * ),get(957),get(199),get(377),set(372,2686),get(114),set(212,1905),get(197
	 * ),set(1049,535),set(1382,608),set(454,1082),get(366),set(416,1931),set(
	 * 318,1106),get(269),get(1242),set(1333,3264),set(1350,220),set(200,2216),
	 * get(392),set(556,2487),get(464),set(1132,3286),get(879),get(1277),set(348
	 * ,2345),get(1039),set(715,187),set(112,2658),set(231,961),get(582),set(
	 * 1343,411),set(863,1497),get(175),set(151,1433),get(1399),get(1080),get(23
	 * ),set(328,1188),get(850),get(870),set(900,841),set(899,659),set(1059,2787
	 * ),set(1052,1571),set(14,855),set(531,2224),get(207),get(166),set(184,1798
	 * ),get(63),set(1396,2011),get(1029),get(1229),get(16),get(920),set(697,64)
	 * ,set(232,2462),set(327,3087),set(343,2848),get(1408),set(1122,1839),set(
	 * 1024,513),set(553,2238),set(1031,3267),set(1388,2886),set(202,2707),set(
	 * 408,1363),set(1190,997),get(1167),get(1240),get(604),set(995,2725),set(
	 * 1069,1977),set(970,3040),set(1044,1124),set(1342,1617),get(1407),get(854)
	 * ,set(532,3298),set(798,2451),get(707),get(900),set(1232,1737),set(1124,
	 * 1767),get(1120),set(1407,2412),get(41),set(1219,127),set(670,1219),get(
	 * 849),get(1004),set(1375,2615),get(1089),get(922),set(1375,1591),set(175,
	 * 3285),set(290,2765),get(307),set(145,62),get(1193),set(722,19),set(257,
	 * 918),set(548,906),set(45,1749),get(147),set(1266,1602),set(1063,1991),set
	 * (602,2624),get(1193),set(58,1292),set(59,2708),get(1354),set(1168,2694),
	 * set(301,2115),set(47,895),set(978,1737),get(485),get(896),get(337),get(
	 * 792),set(1418,2340),get(68),set(1257,1496),set(1250,1778),get(539),get(
	 * 1323),get(917),get(231),set(110,3163),set(875,2046),get(875),get(184),set
	 * (705,2580),get(395),set(806,2123),get(801),get(1020),set(1431,1073),get(
	 * 756),set(465,1489),set(697,546),set(1405,669),set(408,2554),set(307,712),
	 * get(17),set(891,824),set(393,2705),get(298),set(846,20),set(91,2503),get(
	 * 233),set(63,2583),set(44,3159),get(1114),set(870,1756),get(753),set(271,
	 * 2394),set(6,1316),set(169,2153),set(1283,3),get(401),set(910,1841),set(
	 * 177,2131),set(970,2024),set(1372,2361),get(335),get(1208),get(1034),set(
	 * 248,3134),set(1156,1114),get(1034),set(1059,766),get(161),set(340,1395),
	 * set(1333,932),set(1337,2359),set(690,463),get(22),set(400,1594),get(624),
	 * set(1281,2950),set(446,1274),set(94,3291),get(233),set(545,2490),set(358,
	 * 2922),set(230,928),set(892,783),get(559),get(608),get(537),set(1401,686),
	 * get(550),get(1328),get(583),get(347),set(1203,2711),set(517,1602),get(
	 * 1279),get(434),set(536,3206),set(1286,2074),get(70),get(217),set(887,2855
	 * ),get(1318),get(811),set(309,1652),get(1284),set(449,742),set(240,242),
	 * set(267,778),get(1373),set(1195,3133),set(318,2175),set(148,2086),set(102
	 * ,1094),get(466),set(76,339),set(380,2113),get(1100),set(444,3137),get(
	 * 1184),set(539,1008),set(173,3020),set(802,1192),get(3),get(538),get(956),
	 * set(888,1452),set(11,245),set(891,2635),set(1317,2008),set(1264,1855),get
	 * (301),get(986),set(703,677),get(1100),set(1084,652),set(1017,2434),get(
	 * 309),get(503),set(1068,2129),set(317,782),get(1010),get(916),get(604),get
	 * (828),get(1134),set(984,2),get(374),get(203),set(440,494),set(644,2123),
	 * set(874,614),get(1193),set(1108,2917),get(907),get(1304),set(1166,1267),
	 * get(1302),get(1152),set(691,1321),set(1406,1935),set(135,2872),get(231),
	 * set(215,1787),set(1019,1319),set(1425,2538),get(130),get(136),get(89),set
	 * (1378,1995),set(907,938),set(940,675),get(1152),set(1110,2231),set(1080,
	 * 725),set(557,305),set(32,701),set(1336,771),set(827,1267),set(265,1352),
	 * get(1106),get(154),get(950),get(1316),set(1249,690),get(434),get(741),set
	 * (205,3214),get(1080),set(318,392),get(1304),set(1168,1501),get(1094),set(
	 * 1061,183),set(984,2438),get(634),get(825),get(645),set(935,1694),get(817)
	 * ,set(637,1598),set(935,2908),set(1385,2609),set(862,3199),get(883),get(
	 * 604),set(1285,1039),get(471),set(421,373),get(439),get(1056),set(776,2299
	 * ),set(130,1761),get(1010),set(131,2728),get(193),get(1134),get(837),get(
	 * 969),set(793,280),set(73,3163),set(1412,515),set(841,1894),set(1270,2117)
	 * ,set(349,126),set(1272,609),get(544),set(1403,1263),set(526,2679),set(612
	 * ,2793),get(852),get(1044),get(837),get(1147),set(483,2139),set(313,753),
	 * set(1044,2705),set(458,1677),set(844,2756),get(383),set(676,1459),get(419
	 * ),set(1103,271),get(145),get(152),set(387,1946),set(753,96),get(483),set(
	 * 469,2219),set(1238,893),set(1187,449),get(186),get(364),set(76,3021),get(
	 * 493),get(1239),set(689,3158),get(290),get(1424),get(1172),get(1016),get(
	 * 179),get(320),set(235,602),set(1207,448),set(963,1011),get(1384),set(373,
	 * 2930),get(591),get(674),set(815,351),set(477,906),get(106),set(1359,721),
	 * get(898),get(96),set(1295,1855),set(185,2804),get(1324),set(188,2477),set
	 * (1411,2209),get(1262),set(536,579),get(1410),set(63,1356),get(867),set(
	 * 1235,853),get(593),get(1362),get(301),set(1233,1089),get(1025),get(508),
	 * set(102,1513),set(998,1167),set(791,3092),get(967),get(1375),get(1386),
	 * get(525),set(494,3177),set(1068,2881),set(407,127),set(1,1707),set(976,
	 * 1828),set(869,1597),get(1262),set(865,1123),set(734,1540),set(345,1055),
	 * set(406,236),set(669,2175),set(342,2691),set(1,1713),set(938,2940),set(
	 * 1107,2957),set(154,867),get(1234),set(1252,807),get(694),get(842),get(613
	 * ),get(1035),get(367),set(987,901),set(1191,2075),set(67,2235),set(1430,
	 * 415),set(1251,2659),set(612,2552),get(231),set(1044,516),set(735,1796),
	 * get(1419),set(664,1749),set(481,1448),get(117),get(488),set(1399,528),get
	 * (766),set(322,3134),get(1110),get(935),set(1045,7),set(183,2705),get(167)
	 * ,set(1012,1063),set(391,1748),get(1190),set(544,2335),get(328),get(1256),
	 * set(817,2517),get(824),get(190),set(378,96),get(1269),get(119),set(980,
	 * 1026),get(854),set(285,2332),set(32,1563),set(835,2828),get(1063),set(501
	 * ,1231),get(587),set(36,924),get(440),get(1313),set(221,2040),set(1132,139
	 * ),get(1109),set(494,152),get(875),get(468),set(566,1741),set(216,2546),
	 * set(1176,2973),get(50),get(1050),set(1051,1558),get(191),get(1195),set(
	 * 389,2605),set(398,2806),get(1395),get(794),get(502),set(270,388),set(494,
	 * 2116),set(220,3157),set(1360,1991),set(832,1350),set(297,2293),set(820,
	 * 3181),get(1062),get(746),get(563),get(1397),get(1111),set(399,3079),set(
	 * 600,650),set(220,283),set(149,2674),set(96,218),set(258,1067),set(639,
	 * 1570),get(410),set(846,1402),set(337,509),set(1034,363),set(1346,26),get(
	 * 494),get(273),set(86,3012),set(738,1595),set(218,1577),get(101),set(951,
	 * 1566),get(659),get(1038),get(1251),set(1,1526),set(251,1074),set(1077,
	 * 1030),set(711,163),get(393),get(493),set(208,2504),set(50,1405),set(418,
	 * 2039),get(1243),get(230),set(822,663),set(722,268),get(235),get(1338),set
	 * (1171,136),get(1200),get(1249),set(335,1625),set(1286,2238),set(1283,1874
	 * ),get(1172),set(562,420),set(1346,2742),set(977,2815),get(1202),set(47,
	 * 3169),set(747,512),get(1009),set(103,2428),get(651),get(544),get(285),get
	 * (860),set(203,1860),set(1151,2538),set(1206,639),get(678),set(868,2803),
	 * get(931),get(1250),get(36),set(10,934),set(149,1725),set(551,717),get(558
	 * ),set(82,125),set(662,3271),set(1409,3040),set(83,2883),get(154),set(1425
	 * ,1881),set(1403,971),set(426,2583),set(1215,2212),get(172),get(1394),set(
	 * 1275,2519),set(1093,1349),get(685),set(934,1585),set(282,1793),set(1109,
	 * 1251),get(827),get(1244),get(544),get(171),set(843,2042),set(153,2032),
	 * set(265,2414),get(47),get(1430),set(927,2832),set(1111,1997),get(1199),
	 * set(777,2133),set(435,1906),get(212),set(888,3040),get(405),set(885,2085)
	 * ,set(578,1199),get(1281),get(902),set(1320,2670),get(414),set(978,1082),
	 * get(774),set(879,3051),set(1358,2139),set(249,2257),get(756),set(535,1544
	 * ),get(440),set(559,855),set(137,1366),get(780),get(321),set(779,3010),set
	 * (1076,3051),set(428,293),get(227),get(1363),get(1187),set(1153,1992),set(
	 * 294,323),get(354),get(974),get(805),get(13),set(33,2273),get(19),set(684,
	 * 1246),get(1289),set(1381,2111),set(1073,351),set(991,535),get(461),set(
	 * 333,2928),get(1105),set(1298,1071),get(377),get(680),set(717,3021),get(
	 * 1348),set(720,262),set(1010,166),get(404),set(1105,2192),get(443),set(
	 * 1141,525),set(1430,1843),get(751),get(963),get(1265),set(139,1430),set(
	 * 993,1211),set(684,2115),set(280,630),set(55,3214),set(753,610),set(1063,
	 * 1835),set(954,2280),set(463,787),set(1199,187),set(982,2508),get(155),get
	 * (411),get(1073),set(1045,2309),set(295,532),set(209,1792),set(404,2063),
	 * set(882,579),set(927,127),get(515),get(418),set(351,2284),set(1169,645),
	 * get(1183),set(707,1651),get(18),set(43,1452),get(281),set(728,614),set(
	 * 1172,3154),get(559),get(135),get(646),get(191),set(148,2640),set(761,104)
	 * ,set(970,1591),set(211,2250),set(10,2401),set(590,2848),get(1206),set(637
	 * ,1786),set(644,919),set(129,1595),get(913),set(784,93),set(1141,2470),get
	 * (996),get(557),set(1366,2980),set(671,1115),set(87,806),get(440),set(601,
	 * 3260),set(699,170),get(1002),get(1240),get(770),set(892,1914),set(1030,
	 * 473),set(160,2552),get(566),set(186,1304),get(191),set(594,3016),set(1114
	 * ,1701),set(625,1917),set(153,566),get(1364),get(106),set(859,3269),get(
	 * 519),set(470,2801),get(367),set(1031,2331),get(401),set(1378,2259),set(
	 * 322,2146),get(466),get(1001),get(797),get(127),get(783),set(116,3298),set
	 * (774,3092),set(197,2429),get(712),set(772,30),get(1078),get(1281),set(328
	 * ,1205),get(578),get(1311),set(793,1132),get(1081),get(371),get(1212),set(
	 * 304,2703),get(1031),get(332),set(891,1876),set(514,1963),get(1332),set(
	 * 854,353),set(1266,1155),get(1289),set(715,3161),set(610,2496),set(1116,
	 * 1135),set(343,2787),set(1082,242),set(1150,2841),set(488,580),get(757),
	 * set(565,1710),get(765),get(483),set(131,2019),set(1216,2219),set(335,2558
	 * ),set(1065,151),set(302,1995),get(331),get(1252),get(1430),set(108,2597),
	 * set(1354,3152),set(598,1969),get(499),set(449,1242),get(886),set(94,414),
	 * set(245,725),get(727),set(130,3019),set(1296,117),get(381),get(956),set(
	 * 699,615),get(518),get(1293),set(210,3257),set(1374,635),set(966,2976),set
	 * (323,305),get(291),set(833,1580),set(777,2756),set(55,2040),set(1158,3018
	 * ),set(825,43),get(1050),set(92,3242),get(372),get(904),set(947,2697),get(
	 * 375),set(137,1636),get(711),set(491,404),set(1052,1186),set(578,1216),get
	 * (672),get(1164),set(423,3102),get(411),set(1396,567),get(837),set(1216,
	 * 1122),set(1414,142),get(396),get(561),get(1359),get(429),set(603,1058),
	 * get(924),set(39,1208),set(824,1301),get(967),get(426),set(106,2897),get(
	 * 148),set(996,1941),set(238,3231),set(982,2041),set(230,2742),get(1398),
	 * set(1117,1585),set(185,965),set(904,1767),set(698,2147),get(672),set(1272
	 * ,3151),set(239,648),get(682),set(434,3259),get(796),get(1226),set(570,
	 * 2678),get(759),get(1049),get(443),get(9),set(1207,449),get(847),set(579,
	 * 2924),set(1415,116),set(302,2059),set(951,1429),get(373),set(899,1684),
	 * set(151,1325),get(1032),set(1054,3120),set(662,2060),set(179,1486),set(
	 * 351,2448),get(1405),set(1421,3258),get(101),set(723,1773),set(1105,236),
	 * set(292,3011),get(866),get(662),set(32,1098),set(229,2868),set(321,2663),
	 * get(1158),set(1063,79),get(192),get(722),set(122,624),set(716,1248),set(
	 * 509,1589),set(1253,2593),set(259,2449),get(864),set(219,2329),set(953,120
	 * ),get(1284),set(1067,3192),set(167,869),get(254),set(898,227),set(317,
	 * 1090),set(960,2626),get(852),get(685),get(1232),set(1427,1884),set(1236,
	 * 956),set(727,2832),get(344),get(1011),get(210),set(1318,3166),set(1215,
	 * 292),get(959),get(375),set(881,2073),get(409),set(371,2640),get(791),set(
	 * 720,359),set(1071,1467),set(287,697),set(900,629),set(1292,2802),get(23),
	 * get(946),set(311,3019),get(1107),set(679,518),set(1364,2849),get(1354),
	 * get(1033),set(1070,1508),get(1228),set(945,1121),set(1018,2529),set(934,
	 * 67),set(1243,336),get(268),get(557),set(1294,2830),get(112),set(1288,2965
	 * ),set(234,1295),set(1422,315),set(1148,1372),set(1426,178),get(171),get(
	 * 881),set(1317,3291),get(1324),set(57,2681),set(1098,1345),set(70,237),set
	 * (994,2574),set(643,1783),get(438),set(1418,2766),get(1045),set(152,851),
	 * set(739,878),set(103,3055),get(1135),get(912),set(231,3222),set(1234,2613
	 * ),set(202,1365),set(192,1889),get(439),set(215,3150),get(769),get(1212),
	 * get(620),set(247,45),get(426),set(1430,287),set(941,1787),get(406),get(
	 * 308),get(914),set(804,2245),get(706),get(635),set(1231,1755),set(896,495)
	 * ,set(48,1808),set(838,841),set(493,3260),set(300,1442),get(769),set(1295,
	 * 2107),set(1263,135),get(193),set(880,2171),set(934,2914),set(333,2158),
	 * get(1074),get(16),get(185),get(1183),get(501),set(1257,2292),set(830,1588
	 * ),set(354,2220),get(1044),set(1031,310),get(81),set(1165,868),set(1427,
	 * 2523),get(56),get(828),set(1229,1506),set(160,928),get(829),get(446),set(
	 * 749,1895),set(1170,2944),get(1410),get(985),set(1400,2337),get(36),get(
	 * 328),set(453,1433),set(1379,2967),set(352,1395),set(961,2980),get(862),
	 * get(1077),set(385,557),set(431,2976),set(297,2757),get(562),set(1222,3180
	 * ),get(9),set(922,2376),set(648,198),set(989,425),set(1172,3294),set(117,
	 * 620),set(810,1100),get(284),get(19),get(162),get(1297),get(842),get(1097)
	 * ,get(48),set(1280,3214),set(747,3117),set(1050,820),get(1371),get(145),
	 * get(267),get(297),set(52,3099),set(351,2801),set(1,2315),set(821,3085),
	 * get(1037),get(806),get(843),get(1115),set(438,287),get(1031),set(293,1830
	 * ),set(743,1326),set(284,1470),set(855,1957),get(995),get(836),set(983,613
	 * ),get(1238),get(22),get(906),get(751),get(564),get(382),set(969,811),get(
	 * 227),get(1035),get(1109),set(685,1109),set(569,3032),set(865,1439),set(
	 * 374,2481),set(193,1601),set(917,2884),get(712),set(91,3081),set(571,2782)
	 * ,get(717),set(808,2719),set(679,2043),get(814),set(937,2789),set(1063,890
	 * ),set(830,22),set(941,677),set(354,1267),set(610,2252),set(1166,1062),get
	 * (1108),get(684),set(1341,1531),set(457,1670),get(54),set(440,39),set(609,
	 * 1403),get(481),get(1318),get(1216),set(1364,2810),set(681,1709),set(1203,
	 * 2318),set(724,287),get(630),set(701,557),set(390,2721),get(1048),get(201)
	 * ,set(1216,3123),set(451,1396),get(212),set(424,2904),set(998,743),set(441
	 * ,3297),set(206,1546),get(1415),set(1019,1689),get(76),set(978,1827),set(
	 * 1220,1505),get(756),get(990),set(157,2315),set(1299,3205),get(1127),set(
	 * 449,313),set(349,712),get(915),set(718,2310),set(4,1878),set(614,255),get
	 * (566),set(1074,2311),set(687,756),set(571,961),set(148,3123),get(1262),
	 * get(1018),set(372,1175),set(646,1231),get(98),set(399,748),set(1395,1053)
	 * ,get(40),set(1169,2871),set(1203,3126),set(781,1104),get(153),set(681,
	 * 3198),get(697),set(456,571),set(759,1269),set(745,2918),get(697),set(1332
	 * ,741),set(943,1623),set(244,1295),get(631),get(462),set(869,763),get(399)
	 * ,set(1172,2092),set(745,1702),get(561),get(753),set(603,2094),set(914,780
	 * ),set(1128,318),get(216),set(556,315),set(808,85),get(204),set(876,215),
	 * set(1,2648),get(24),set(886,936),get(1028),set(969,2636),set(1318,3057),
	 * set(240,3303),set(1085,514),set(250,1965),set(151,491),set(1328,1619),set
	 * (1056,410),get(937),get(912),get(1152),set(928,262),set(924,2517),set(943
	 * ,2894),set(253,2341),set(232,2317),set(1056,274),get(637),get(1379),set(
	 * 147,1956),get(1189),set(935,1185),get(192),set(383,838),get(1008),set(441
	 * ,888),get(771),get(71),set(112,3274),get(157),set(1229,3125),set(180,3081
	 * ),set(349,1526),set(1313,366),get(327),set(154,1219),get(1073),get(740),
	 * set(1323,3300),set(979,2792),get(344),set(1055,2906),get(160),set(327,853
	 * ),set(425,2461),set(688,1342),set(827,38),set(1130,3057),set(1360,1786),
	 * get(829),get(1173),get(462),get(660),set(439,1631),get(569),set(1379,3115
	 * ),get(868),set(467,1621),get(1287),get(1375),set(897,33),set(1313,1869),
	 * get(212),set(296,339),get(596),set(731,3135),get(1267),get(62),get(147),
	 * set(353,1572),set(1372,2067),set(1403,1312),get(1110),get(40),get(455),
	 * set(852,489),set(1179,1832),get(201),set(201,661),get(1077),set(1096,637)
	 * ,get(469),get(323),get(565),set(223,660),get(1376),set(380,1141),set(62,
	 * 2547),get(1052),set(316,830),set(474,1474),get(475),set(424,1502),set(596
	 * ,2777),set(820,2875),get(995),get(725),set(865,1719),set(1081,1263),set(
	 * 859,3191),get(632),get(1205),get(420),get(933),set(921,2603),get(1167),
	 * set(647,180),get(744),set(14,532),set(1079,294),set(1275,917),set(1145,
	 * 1309),set(126,1011),get(1201),get(682),get(1408),set(101,1192),set(1391,
	 * 1133),set(751,312),set(344,1634),set(882,477),set(1106,503),set(273,766),
	 * set(1364,520),set(1042,2915),set(350,2488),set(457,624),set(320,297),get(
	 * 276),get(48),set(1396,2209),get(615),get(1246),get(1422),get(306),get(
	 * 1349),get(1073),get(387),set(1295,2616),set(346,2034),get(573),set(956,
	 * 588),set(1264,342),get(56),get(375),get(967),get(1090),get(1241),set(1313
	 * ,3044),get(1174),get(276),get(298),set(1160,1625),set(1000,2617),set(1318
	 * ,380),set(566,949),get(362),set(1290,1723),set(412,1576),set(1115,1568),
	 * set(584,1421),set(1049,2800),set(1014,1669),get(1292),set(1096,1910),get(
	 * 1250),get(1193),set(1222,456),set(1116,460),set(146,2143),get(227),get(
	 * 942),set(1148,3258),set(1313,1611),set(1427,843),get(1073),get(801),get(
	 * 136),set(297,2671),set(69,425),set(596,3138),set(610,3261),get(319),set(
	 * 714,2782),get(1179),get(43),set(105,41),set(203,2185),set(1266,744),set(
	 * 1419,1120),get(1376),set(1345,3149),set(1371,2184),set(1188,1949),get(615
	 * ),set(252,3080),set(837,2152),set(798,1487),set(481,2329),get(257),get(
	 * 846),get(1037),set(1099,3086),get(821),set(676,913),set(1131,1443),set(
	 * 345,1397),get(483),set(1,983),get(578),set(431,623),set(994,491),get(247)
	 * ,get(462),set(1174,198),set(774,2476),set(518,3065),set(1322,286),get(831
	 * ),get(171),get(477),set(457,1204),get(223),get(295),get(459),set(433,2232
	 * ),set(257,3152),set(80,24),get(596),get(853),get(423),set(963,1770),set(
	 * 801,1217),set(1274,1458),set(1355,3183),set(425,1193),get(966),set(270,
	 * 421),set(856,3140),set(44,2670),set(1407,540),get(987),get(474),set(1050,
	 * 1633),set(46,627),get(768),set(1209,2646),get(135),set(1340,2354),set(916
	 * ,1111),set(1146,2925),set(286,870),get(28),set(1225,1600),set(606,1300),
	 * get(231),get(843),set(156,2982),set(1124,952),set(218,668),set(1019,708),
	 * set(1204,811),get(503),get(1102),get(904),set(640,2250),get(1333),get(715
	 * ),set(346,70),set(971,1787),set(1243,1097),set(684,1868),get(1187),set(
	 * 1160,2168),set(1311,2264),set(798,1254),set(1150,867),get(976),set(329,
	 * 1136),set(468,1505),set(639,1122),set(1294,280),set(693,1889),get(1365),
	 * get(417),set(902,1435),get(21),set(791,2737),get(1206),set(1338,3219),get
	 * (832),get(493),set(615,1020),get(1084),get(636),get(598),get(239),set(587
	 * ,2917),set(1221,1831),set(877,1289),set(518,2225),get(1096),get(823),get(
	 * 819),set(579,1091),get(491),get(276),set(743,413),set(1279,1208),get(921)
	 * ,set(499,359),get(22),get(811),get(887),set(382,103),get(549),set(33,14),
	 * get(752),set(1090,2345),set(1193,2191),get(680),get(1170),set(715,1226),
	 * set(596,675),set(831,984),set(525,2406),set(775,741),set(215,1349),get(
	 * 863),get(603),set(389,2046),get(904),set(103,1098),get(1293),get(1360),
	 * set(442,2737),set(936,53),set(638,1121),set(638,2036),set(903,2528),set(
	 * 817,2991),set(1413,1776),get(983),set(1414,810),set(550,2210),get(1083),
	 * set(363,1200),set(970,113),set(91,2456),set(639,173),set(1243,1479),set(
	 * 1137,1),get(484),set(781,1874),set(209,655),get(126),get(193),get(123),
	 * set(274,2361),get(1093),set(946,183),set(246,2755),get(418),set(317,2405)
	 * ,get(1103),get(576),set(688,3285),get(881),get(345),set(541,2885),set(90,
	 * 2730),set(1429,2360),get(14),get(403),get(260),set(641,1069),set(457,158)
	 * ,get(930),get(609),set(751,2159),get(679),set(492,1111),set(583,2598),get
	 * (149),set(1314,212),get(277),set(1372,1675),set(662,1961),set(1147,2900),
	 * set(280,2872),set(152,2462),set(845,403),set(633,1583),set(341,2912),set(
	 * 995,3227),set(217,2074),get(1351),set(1407,796),get(997),get(392),get(
	 * 1324),set(200,797),get(668),set(712,757),set(1183,584),get(1033),set(921,
	 * 1094),set(73,2459),set(722,1249),set(1310,321),set(125,2712),get(328),get
	 * (869),set(339,1536),get(659),get(1008),get(1273),get(1107),get(285),set(
	 * 100,1903),set(194,1077),set(684,1699),set(331,1076),get(432),set(1018,
	 * 2840),set(1098,170),set(602,700),set(256,1572),get(1003),set(785,65),set(
	 * 493,764),get(298),get(263),set(353,3159),set(1101,46),get(382),get(566),
	 * set(59,502),set(1099,687),set(251,2039),set(647,2041),get(1238),set(873,
	 * 1185),get(643),set(303,1871),set(85,3111),get(37),set(217,2369),get(309),
	 * set(364,1660),set(1047,2536),get(363),set(1170,1179),set(1231,138),get(
	 * 1214),get(1212),get(75),set(1355,1758),get(1074),set(460,1717),set(67,
	 * 1579),set(881,1866),get(195),get(693),set(917,2357),set(735,1730),get(86)
	 * ,set(1143,106),set(899,699),set(670,2516),get(598),get(436),set(90,605),
	 * get(703),set(596,71),get(481),get(540),set(326,2291),get(259),set(271,363
	 * ),get(678),set(1235,243),get(1317),set(49,279),get(132),get(1225),get(
	 * 1202),get(126),set(875,575),set(979,1051),get(1352),set(905,977),set(767,
	 * 3172),set(423,1514),get(974),set(35,1908),get(1105),get(1408),get(361),
	 * set(316,528),get(30),set(1041,2521),get(839),set(225,3017),get(498),get(
	 * 1178),get(701),set(983,1450),set(480,1890),set(95,439),get(219),set(872,
	 * 2965),get(1092),get(620),set(1352,308),set(283,2578),set(500,3097),set(
	 * 881,2788),get(1261),get(637),set(1320,459),set(267,1599),get(295),get(682
	 * ),set(610,1715),set(380,3142),set(339,131),set(437,1558),set(1301,2333),
	 * set(524,1538),set(348,3154),set(1132,2264),set(901,881),set(832,891),get(
	 * 776),get(605),get(452),get(514),get(754),get(138),get(1157),get(1130),set
	 * (223,2461),set(1371,2692),set(94,3115),set(194,2010),set(574,3233),set(
	 * 1297,321),set(1345,686),set(1282,711),get(1318),get(360),get(712),get(215
	 * ),set(755,2882),get(547),set(551,258),set(698,1986),get(1400),set(119,
	 * 3278),get(51),set(43,2488),get(1137),set(1005,1675),set(780,1745),get(357
	 * ),set(791,1793),get(521),set(1406,1387),set(1380,1171),set(1119,1435),set
	 * (735,942),get(660),set(1008,1768),set(519,3247),get(1272),get(483),get(
	 * 1088),set(1402,1816),set(1324,2575),set(254,907),set(565,1539),set(973,
	 * 1991),get(1002),set(1032,2741),get(1093),get(411),get(165),set(635,859),
	 * set(1143,1208),set(891,1505),set(1274,2164),get(359),set(865,2837),get(
	 * 530),set(809,2360),get(1243),get(540),get(315),get(597),get(933),get(234)
	 * ,set(598,1975),get(1122),set(1046,2920),set(1205,2073),get(1022),get(1099
	 * ),get(1069),set(307,747),get(296),get(117),set(785,417),get(570),set(548,
	 * 2457),get(340),set(588,3097),set(1159,192),set(809,2890),set(205,300),set
	 * (526,3087),set(1287,439),set(1368,649),get(902),set(1349,611),get(314),
	 * set(205,1659),get(1168),set(551,318),set(964,527),set(185,2930),set(803,
	 * 458),get(1148),set(792,1445),get(1341),set(1342,1808),set(1005,2129),set(
	 * 509,3109),get(892),set(569,1164),get(773),set(1096,2811),set(1214,775),
	 * get(1379),get(1369),set(569,2101),get(93),set(1192,473),set(1096,3082),
	 * set(1270,730),set(711,1887),set(136,94),get(739),set(663,1951),set(54,994
	 * ),set(1018,106),get(866),set(785,2763),set(1160,1210),get(747),set(278,
	 * 174),get(281),get(583),set(582,2377),get(911),set(216,3083),get(921),set(
	 * 1065,949),get(71),set(506,1263),set(1261,3150),get(597),set(1420,1655),
	 * get(1151),get(730),set(218,2224),set(302,3132),get(1122),set(894,340),get
	 * (39),set(1117,1967),get(239),get(1226),set(1244,97),set(212,3038),set(
	 * 1249,761),set(1349,122),get(416),set(194,1728),set(1203,277),set(172,1738
	 * ),set(1055,579),set(418,469),get(27),set(1094,854),get(1395),get(586),set
	 * (827,185),set(631,274),get(1005),set(1089,3125),get(113),get(1330),get(
	 * 1322),set(1053,1116),set(330,1365),get(1337),get(441),get(362),set(576,
	 * 2992),get(574),set(1383,170),get(188),set(921,1307),get(1011),get(823),
	 * set(1049,2005),get(323),set(616,786),get(410),set(1058,82),set(1110,2504)
	 * ,set(1026,1571),get(296),get(602),get(331),get(91),get(373),set(772,1918)
	 * ,set(861,796),set(661,2324),get(656),get(1301),set(1341,1860),get(101),
	 * set(1316,90),get(1325),set(167,1419),set(1095,414),set(793,2214),set(1418
	 * ,1932),get(833),get(1356),get(992),get(1218),get(336),set(1055,2996),set(
	 * 708,625),get(690),get(954),get(157),get(112),get(47),set(1170,3128),set(
	 * 659,917),get(1366),set(215,181),set(1003,1168),get(1223),set(963,1269),
	 * get(161),set(1085,2947),get(320),get(170),set(1048,944),set(1102,820),get
	 * (1244),set(152,384),set(1063,2370),set(1388,2312),get(968),get(1102),set(
	 * 363,207),set(865,1930),get(1205),get(715),get(129),get(702),set(371,124),
	 * get(935),get(115),set(265,135),set(744,2886),get(26),get(329),get(1374),
	 * set(1320,2684),set(329,2713),get(1053),get(747),set(641,37),get(597),get(
	 * 25),set(840,137),set(832,3051),set(1087,996),set(898,269),set(666,3279),
	 * get(939),set(575,1939),set(1379,1276),get(431),get(1009),set(736,213),get
	 * (888),set(139,60),set(1097,1426),set(1218,3051),set(1291,1168),get(30),
	 * set(323,2707),set(494,2659),set(1372,1481),set(881,273),get(278),get(176)
	 * ,set(413,572),set(723,1487),get(449),set(1317,539),get(2),set(922,925),
	 * set(314,2322),set(1176,1718),set(353,56),set(803,1635),set(243,551),set(
	 * 972,3212),get(1420),set(1377,2204),get(956),get(263),set(312,2917),set(
	 * 961,144),set(531,277),set(243,1204),set(1191,376),set(399,369),set(766,
	 * 2669),set(463,1523),get(103),get(1328),set(416,1876),set(693,2762),set(
	 * 613,2263),set(532,1506),set(1055,971),get(870),set(1260,1265),get(912),
	 * get(737),set(719,331),set(1315,1843),get(1400),set(1304,181),get(1291),
	 * set(163,158),set(97,717),set(1345,2127),get(901),get(283),get(1126),get(
	 * 725),set(967,225),get(954),get(1070),set(783,3272),set(944,1532),get(45),
	 * get(475),set(350,1106),set(133,2866),set(973,714),set(988,1058),set(213,
	 * 143),get(24),set(434,284),set(1179,826),set(363,2266),get(596),get(849),
	 * get(642),set(511,2760),set(1015,2215),set(1030,602),set(995,1793),set(86,
	 * 1597),get(1242),get(270),get(588),get(577),set(1255,1881),get(1403),get(
	 * 1284),set(307,2930),get(148),set(1257,2199),set(657,1343),get(574),get(
	 * 325),set(976,1696),get(678),set(55,1551),get(1040),set(1205,3116),get(803
	 * ),set(2,2526),set(1014,3239),get(1381),get(1117),get(233),get(1095),get(
	 * 971),set(281,3279),set(27,1320),get(1192),get(299),set(454,1457),get(596)
	 * ,set(167,2864),set(45,2937),get(288),get(796),set(612,3196),set(1109,1957
	 * ),set(666,1084),set(781,1024),set(475,1133),get(949),get(1360),set(796,
	 * 1140),set(1128,2598),set(210,419),set(1244,1405),set(1156,2719),get(810),
	 * get(452),set(264,254),set(1002,2410),get(261),get(447),set(514,630),set(
	 * 285,1405),set(1229,1785),get(72),set(536,2511),get(1378),set(1273,2461),
	 * set(798,2590),set(524,1018),set(1002,2092),set(573,1751),set(675,239),get
	 * (1067),set(92,1246),set(1352,1145),get(1147),get(1338),get(563),set(531,
	 * 84),get(206),get(481),set(238,1547),set(621,2652),set(710,2836),set(602,
	 * 2946),set(515,1027),set(1157,1188),get(518),get(1188),get(680),set(346,
	 * 2308),get(513),set(348,404),set(7,147),get(720),set(803,1421),get(722),
	 * get(1104),set(586,2657),set(692,1035),get(747),get(960),set(1420,1800),
	 * set(24,767),get(1347),set(534,2004),set(859,3143),get(100),get(1370),get(
	 * 1393),get(873),get(922),set(1348,3247),get(935),get(1386),set(1183,1861),
	 * set(1178,1693),get(1184),set(1361,457),get(1285),set(194,881),set(1211,
	 * 641),set(351,1248),set(614,163),set(329,1025),get(888),set(34,1592),set(
	 * 125,970),get(453),get(509),set(1299,1194),get(238),get(421),set(713,82),
	 * set(631,226),set(1224,2025),get(251),get(164),get(715),get(776),get(66),
	 * set(273,455),set(1143,301),get(545),set(1241,2361),get(690),get(383),set(
	 * 145,862),set(314,1525),get(511),set(460,3229),get(958),set(1079,359),get(
	 * 1106),set(1316,1345),get(819),get(840),set(826,3024),get(953),get(1347),
	 * set(620,1097),get(595),set(1177,1734),set(790,1311),set(1298,652),set(34,
	 * 1358),get(470),get(160),set(325,3012),get(1386),get(692),get(566),set(507
	 * ,1189),set(1126,2603),set(1204,2099),get(574),set(1323,3024),get(208),set
	 * (965,217),get(692),set(1199,452),get(372),set(781,1400),get(183),set(443,
	 * 1343),get(1292),set(818,744),set(515,3248),get(219),get(536),set(1256,
	 * 2614),get(719),set(277,691),set(1214,2912),get(802),set(509,132),get(340)
	 * ,set(875,455),set(1391,2628),get(203),set(756,2050),set(271,1202),get(771
	 * ),set(1395,1096),get(702),get(884),set(916,3041),set(838,1186),get(694),
	 * get(657),set(1398,1342),get(477),set(515,656),set(12,855),set(1415,2493),
	 * set(226,2506),set(1135,1326),get(1037),get(717),set(822,2007),set(1419,
	 * 2577),set(1211,2994),get(496),set(303,693),get(592),get(574),set(1006,904
	 * ),get(966),get(545),set(469,1109),set(878,412),set(315,2027),set(529,2912
	 * ),set(142,2432),get(796),set(1286,2209),set(954,1277),get(18),set(741,414
	 * ),set(1423,31),set(377,1692),get(304),set(840,687),set(1310,1335),set(613
	 * ,1691),get(737),get(588),set(987,612),set(349,1829),set(350,280),set(477,
	 * 381),get(216),get(57),set(894,2803),set(1368,2735),set(488,2593),get(1210
	 * ),set(405,2647),get(350),set(1024,1553),set(125,400),get(672),get(623),
	 * get(1158),get(1204),set(904,1636),get(530),get(613),set(226,542),get(1016
	 * ),get(291),get(80),get(922),set(443,2868),get(1323),set(304,2133),set(614
	 * ,757),get(149),set(265,3075),set(334,1821),get(421),get(325),get(1122),
	 * set(1285,1731),set(829,2473),get(1429),get(1343),get(692),get(604),set(
	 * 1031,2751),set(1355,1530),set(334,1446),set(259,3007),get(980),set(838,
	 * 572),get(1292),set(156,1240),get(1263),get(506),get(1259),set(190,2565),
	 * get(339),set(1084,578),set(652,1493),get(527),set(850,867),set(1390,2400)
	 * ,get(281),get(889),get(605),set(616,144),set(143,46),set(180,1939),get(
	 * 652),set(1119,1178),set(1137,1194),set(650,2721),get(562),get(71),get(998
	 * ),get(721),set(20,87),set(383,2887),set(1345,490),set(326,3040),get(1167)
	 * ,set(1216,2085),set(701,2707),get(31),set(1117,1575),get(418),get(142),
	 * set(913,332),get(519),get(1087),set(984,1668),get(533),get(511),get(336),
	 * set(1028,1173),get(1050),set(810,2579),get(249),set(204,2242),set(1419,
	 * 509),get(775),get(68),set(99,507),set(1136,1815),set(148,279),get(76),set
	 * (997,2240),get(778),set(659,509),get(269),set(556,298),get(801),get(822),
	 * set(952,1900),get(68),get(1000),set(1086,854),get(993),get(590),set(595,
	 * 2681),set(1113,656),set(730,1167),set(361,2132),set(1300,1339),set(105,
	 * 3083),set(1144,1301),set(572,2344),get(885),set(793,3216),set(617,1519),
	 * get(8),set(1301,2386),get(276),set(241,1069),get(686),set(763,2438),get(
	 * 704),set(1264,2629),set(1160,2906),set(129,585),get(638),get(989),get(330
	 * ),get(370),set(788,2861),set(740,2140),get(565),set(1199,1541),get(248),
	 * set(934,3112),get(1039),set(1384,3256),set(763,2988),set(1201,875),get(
	 * 831),set(510,3182),set(107,1524),set(588,2189),set(37,2556),get(1230),set
	 * (130,1655),set(858,3136),set(501,419),set(1030,1671),get(867),get(365),
	 * set(1254,473),set(1180,1524),set(1206,3254),set(473,2146),set(1396,473),
	 * get(1067),set(1429,1665),get(325),get(103),set(25,3051),set(1172,1205),
	 * set(1149,497),set(280,1400),get(1227),set(570,1290),set(825,1615),get(864
	 * ),set(429,544),get(893),set(73,1862),set(734,39),get(1276),set(1360,3041)
	 * ,get(1129),set(717,248),get(881),set(1205,1361),set(45,2623),set(245,1879
	 * ),set(1368,2664),get(603),set(548,1551),get(1096),get(866),set(85,239),
	 * get(298),set(249,1547),set(1162,2229),set(284,492),get(1325),set(654,2398
	 * ),set(569,3132),get(942),set(668,1388),set(814,2874),get(1263),set(758,
	 * 1672),set(852,2882),set(706,1036),get(595),set(483,2300),get(311),get(891
	 * ),get(1095),get(1117),set(1217,1177),get(451),get(743),get(1046),get(70),
	 * get(640),get(132),set(1374,417),get(389),get(307),set(1338,2031),get(930)
	 * ,set(1176,2043),get(1354),set(1192,3132),set(240,1541),get(1223),set(413,
	 * 2552),get(1025),get(557),set(304,902),set(691,1301),set(61,3055),get(1126
	 * ),set(337,459),set(1072,1511),set(255,2348),get(1353),get(1155),get(889),
	 * get(1429),get(1407),set(326,2407),set(245,505),get(138),get(352),get(864)
	 * ,set(383,1023),get(1118),set(629,3180),get(183),set(950,365),get(1000),
	 * get(1157),get(1405),get(341),get(1389),get(1376),set(118,119),set(1324,
	 * 533),get(1208),get(22),set(1254,2928),get(1110),get(536),get(518),get(
	 * 1123),set(791,1381),set(303,2736),set(127,3152),set(445,1992),set(235,
	 * 1649),set(259,1140),set(181,2670),set(549,851),set(812,1847),set(1159,
	 * 2903),set(1218,500),set(432,1692),get(1270),set(1156,1503),get(1406),set(
	 * 679,932),set(261,2066),set(1179,1225),set(141,3187),get(810),set(1398,
	 * 1560),get(1097),set(680,330),set(944,2797),set(1370,628),set(759,3174),
	 * get(1117),get(1088),get(1080),set(224,1914),get(138),set(1106,2760),get(
	 * 134),set(3,2978),set(19,1564),set(782,2467),get(851),set(189,1558),set(
	 * 1071,2114),set(536,836),set(1045,276),get(94),get(1144),set(171,318),set(
	 * 18,2417),get(989),set(729,2881),get(308),set(409,1173),set(775,3137),set(
	 * 734,1014),set(827,2738),get(1323),get(1295),set(563,2045),set(997,2540),
	 * set(68,3036),set(785,1208),set(968,2147),get(1431),get(744),set(1288,143)
	 * ,set(875,1805),get(1137),get(144),get(1220),get(802),set(112,566),set(2,
	 * 2855),get(408),set(995,1240),get(651),set(1261,21),set(38,489),set(1085,
	 * 440),get(665),get(89),set(800,475),set(715,1393),get(350),set(429,169),
	 * set(582,2895),set(1234,2139),set(31,114),set(1363,2876),get(232),set(81,
	 * 2519),get(214),set(365,2783),set(1078,560),get(1232),set(1276,23),get(372
	 * ),get(152),get(1158),get(865),set(1141,225),get(26),set(1320,2803),set(
	 * 1008,429),get(879),set(7,3163),set(1417,2128),set(805,1348),get(1345),get
	 * (1136),get(984),set(820,2555),get(348),set(309,860),set(1093,523),set(262
	 * ,144),get(1135),set(446,627),get(1172),get(1426),set(913,454),set(105,
	 * 2531),set(1134,1562),set(700,1023),set(1181,2099),get(938),set(309,2944),
	 * get(1161),get(1090),get(949),set(750,2504),get(497),set(1194,2390),get(
	 * 127),get(1056),get(941),get(369),set(1366,3100),get(717),set(1207,2903),
	 * set(1410,1328),set(689,692),get(731),set(1044,2583),get(600),get(1213),
	 * set(918,1074),set(436,2186),set(365,2557),set(704,3226),get(1391),set(611
	 * ,2001),set(744,2990),set(247,2909),get(1040),set(1419,2468),get(267),set(
	 * 374,1097),set(1324,3250),set(957,145),set(729,2690),set(1263,1589),get(
	 * 270),set(1066,575),get(1054),set(450,2691),set(529,1390),get(435),get(123
	 * ),set(184,2262),get(189),get(758),get(667),set(228,2877),get(247),get(
	 * 1414),get(535),get(645),get(439),set(71,683),get(750),set(314,2955),set(
	 * 751,1372),set(783,2339),get(1013),get(669),set(216,568),get(1029),get(887
	 * ),set(1086,3232),get(1379),set(288,1123),get(901),set(1369,302),get(1324)
	 * ,set(48,1253),set(13,950),set(1128,377),set(794,244),set(20,1384),get(665
	 * ),get(981),set(258,2835),set(512,3299),set(374,2369),get(1317),set(1356,
	 * 1627),set(735,3137),get(1189),set(617,1882),get(1097),get(843),set(1081,
	 * 1137),set(57,1356),set(1255,2869),get(1295),get(344),get(686),set(962,
	 * 1963),set(467,1510),set(855,1143),get(112),set(1033,1991),get(105),get(
	 * 624),get(804),set(850,3017),get(1316),get(1245),set(351,2158),set(947,620
	 * ),set(369,2969),set(336,1386),get(193),set(928,2829),get(1144),get(1048),
	 * get(368),get(1429),set(271,1870),get(1410),get(999),set(210,1793),set(
	 * 1185,2112),get(241),set(212,2822),set(1404,623),set(1059,665),get(513),
	 * set(1167,95),set(1218,1675),get(928),set(270,2518),set(452,140),set(441,
	 * 2578),get(645),get(763),get(1399),set(277,2935),set(629,755),get(586),set
	 * (1200,3256),get(633),get(899),get(622),set(332,1806),get(502),get(472),
	 * get(452),set(48,3102),get(1193),set(251,1146),set(750,2361),get(842),set(
	 * 324,2916),get(1363),get(552),get(703),set(1251,2851),set(348,3037),set(
	 * 580,176),get(182),set(356,952),set(60,2364),get(219),get(1427),get(817),
	 * set(911,191),set(877,3093),set(817,93),set(182,2856),get(843),set(9,1592)
	 * ,set(1401,2779),set(983,1077),get(356),get(913),set(907,122),get(981),set
	 * (722,2610),get(909),set(453,504),set(1397,761),set(465,755),set(79,2217),
	 * set(29,2595),get(1217),set(1105,2935),set(952,1994),set(1171,302),get(754
	 * ),get(235),set(41,267),get(780),set(987,2478),set(637,1180),set(1126,2111
	 * ),set(116,3098),set(84,1024),set(543,2536),set(702,858),set(863,2065),get
	 * (99),set(28,669),set(777,1749),get(22),set(550,3077),get(1233),get(938),
	 * set(367,2762),set(51,1457),set(498,54),set(716,1509),set(897,1297),set(70
	 * ,166),get(1155),get(799),set(121,1351),set(195,948),get(1123),set(354,
	 * 1218),get(617),get(412),set(1120,1408),set(858,3277),set(210,547),set(748
	 * ,1845),set(313,3231),get(821),set(1191,2293),get(994),set(217,3158),get(
	 * 115),set(392,2400),set(984,2027),set(266,126),get(410),set(253,2366),set(
	 * 1195,2931),get(1104),set(450,2345),set(934,908),set(1007,2228),get(1019),
	 * get(1124),set(1110,1047),set(1169,2254),get(979),get(1125),get(731),get(
	 * 832),get(993),get(1426),get(1176),set(714,1618),set(1138,3204),set(456,
	 * 654),set(659,279),set(938,2176),set(171,862),get(487),get(265),get(1),set
	 * (948,331),set(68,114),get(432),get(1390),set(342,105),get(889),get(311),
	 * get(261),set(1361,2206),set(237,830),set(231,1824),set(885,2921),get(1108
	 * ),set(1286,2991),set(1257,2283),set(1169,658),get(864),set(555,1279),set(
	 * 1196,1481),set(1045,1752),get(1145),set(1123,2211),set(1023,1097),set(374
	 * ,1376),set(296,2076),set(83,3111),set(1098,50),get(1375),get(600),set(375
	 * ,2366),get(757),get(1156),set(746,814),set(1165,1705),set(409,2966),get(
	 * 248),set(763,1906),get(947),set(28,276),get(1013),get(736),get(721),get(
	 * 1047),get(260),set(459,1643),get(409),set(894,602),get(548),set(1229,953)
	 * ,get(585),get(867),set(636,2511),get(381),set(418,1183),set(1282,2453),
	 * set(40,1045),set(1415,1234),set(482,1344),get(394),get(481),get(56),set(
	 * 1095,2681),set(534,1586),set(1034,1306),get(905),set(871,1381),get(343),
	 * get(629),get(696),get(1305),get(1007),set(1225,3168),set(685,1640),set(
	 * 204,2784),set(326,2769),get(494),set(1083,1455),set(360,1096),set(1263,
	 * 1549),get(507),get(1031),get(849),get(1340),set(808,2719),set(1132,1762),
	 * get(1151),set(1296,2889),set(413,211),get(1368),get(1299),set(978,1179),
	 * set(526,439),get(677),set(298,3182),set(510,2135),set(7,759),set(510,3077
	 * ),get(697),set(35,2797),set(464,1415),get(391),get(1061),get(573),set(
	 * 1261,1490),get(305),set(214,2281),set(22,3211),get(52),get(225),get(1235)
	 * ,set(1129,3169),set(1170,880),set(707,1036),set(279,199),get(938),get(650
	 * ),set(853,3162),get(324),set(267,1759),set(121,1043),get(661),set(111,
	 * 1893),set(561,2546),set(437,2312),get(797),set(437,2652),get(313),get(
	 * 1116),set(402,98),set(473,698),get(1208),set(963,739),set(332,37),set(
	 * 1297,2835),get(1238),get(1208),get(140),set(1233,387),get(1338),get(301),
	 * get(1377),get(1170),set(362,1228),set(336,3174),set(1176,1579),set(520,
	 * 761),set(807,1166),set(186,2527),set(512,1590),get(1225),set(460,846),set
	 * (1016,1221),set(486,1697),get(16),get(804),set(1325,269),set(28,2090),set
	 * (1427,490),set(400,2778),get(1045),get(1191),get(980),set(258,358),set(26
	 * ,1845),get(1077),get(849),set(516,3132),get(969),get(829),set(726,3106),
	 * get(1385),get(776),get(335),get(301),set(1,1417),get(1022),get(963),set(
	 * 140,2490),get(205),get(1406),set(497,2529),set(1152,2610),get(594),get(
	 * 778),set(995,1273),get(649),get(879),get(495),get(1329),get(406),get(685)
	 * ,get(281),set(367,2898),get(397),set(984,2412),set(1335,2130),get(855),
	 * get(155),get(983),set(1392,2433),set(1244,202),get(557),get(1180),set(992
	 * ,1729),get(1393),set(419,1790),set(695,1572),get(414),get(1341),set(3,448
	 * ),set(1154,85),set(1305,2522),set(987,1760),get(575),get(1240),get(488),
	 * set(1063,1525),set(322,1035),set(1293,1220),get(1117),set(1051,380),set(
	 * 1334,456),set(1185,2721),set(711,1136),set(697,588),set(529,2030),get(
	 * 1161),get(146),get(33),get(392),get(1182),set(1028,2263),set(269,1485),
	 * get(386),get(1296),get(830),get(1038),set(727,486),get(757),get(616),set(
	 * 727,2730),get(745),set(1199,1732),set(749,3230),set(800,2370),set(1427,
	 * 620),get(226),get(819),set(846,3194),get(313),get(1415),set(524,855),set(
	 * 346,387),set(1003,2645),get(607),set(292,158),set(1325,417),get(676),set(
	 * 1277,927),get(884),get(505),set(607,213),set(964,2998),get(810),set(1024,
	 * 1365),set(131,1230),set(732,1784),get(1113),get(1012),get(920),set(1246,
	 * 2851),set(191,1349),set(201,2190),set(187,27),set(1166,697),set(87,257),
	 * set(1382,2599),get(511),set(735,2206),get(55),get(1350),set(219,1623),set
	 * (1417,1376),set(987,2036),set(1329,2932),set(1386,45),get(987),set(178,
	 * 1752),get(479),set(964,1402),set(1076,2874),get(69),set(970,647),set(1221
	 * ,202),set(478,1781),set(247,3296),get(419),set(631,2185),get(902),get(812
	 * ),get(124),get(554),get(417),set(999,1515),set(320,530),get(844),set(1267
	 * ,2888),set(865,6),get(1349),set(1239,395),get(1348),get(72),set(441,1043)
	 * ,get(720),set(1219,3197),set(523,1686),get(755),get(1222),get(1430),set(
	 * 279,1019),set(64,2530),set(1052,556),set(647,817),get(422),set(1305,770),
	 * get(1155),get(1099),get(1359),get(1327),get(1366),set(585,2390),set(313,
	 * 2956),get(430),set(109,275),get(188),set(1347,149),set(86,1617),get(641),
	 * set(308,208),set(1252,823),get(965),set(401,653),get(301),set(386,3141),
	 * set(294,2131),get(1183),set(571,2087),get(40),set(831,2195),set(86,1551),
	 * set(1215,3297),set(180,2605),get(384),set(642,62),get(879),get(979),set(
	 * 643,904),get(1423),set(573,1694),get(193),set(1099,2249),get(1196),set(
	 * 1271,2112),get(1396),get(872),set(1160,2925),set(700,253),set(150,1880),
	 * set(553,3208),set(831,1856),set(32,1690),set(363,1660),set(662,1086),get(
	 * 558),set(211,3217),get(456),set(479,2342),get(854),get(1225),get(60),get(
	 * 916),set(478,2163),get(1332),get(351),set(956,2222),set(605,1717),get(873
	 * ),get(1326),set(484,2996),set(1311,709),get(1102),set(147,600),set(152,
	 * 626),set(735,1600),set(695,1417),get(421),get(205),get(1111),set(8,3133),
	 * set(1022,3086),get(496),set(19,1553),set(831,1628),set(1383,1636),set(26,
	 * 2365),get(1115),set(1305,1235),get(607),set(678,3289),set(993,1230),get(
	 * 1292),set(1191,661),get(204),set(1072,2908),get(1066),set(1181,2743),get(
	 * 1099),get(128),set(1281,5),get(1316),get(893),set(687,133),set(464,2046),
	 * set(812,694),set(676,990),set(183,2173),set(418,946),set(932,2930),set(
	 * 219,1166),set(970,566),get(291),set(746,2715),set(1421,2009),get(1159),
	 * get(1162),set(443,1778),set(405,1722),get(372),set(1416,2230),set(13,1086
	 * ),set(1378,643),get(505),get(488),set(979,3217),set(347,2532),set(958,
	 * 2907),set(940,340),set(1207,2255),set(559,1555),get(746),set(813,315),get
	 * (625),set(1268,1081),set(1122,1505),get(353),set(56,1936),get(1150),set(
	 * 1386,105),set(1352,2981),get(1230),set(586,1619),set(1074,1605),get(655),
	 * set(1257,1238),get(986),get(174),set(1315,1021),set(926,663),get(1259),
	 * set(543,1798),set(1209,694),set(717,1754),get(944),set(625,347),set(1054,
	 * 3210),set(826,2596),get(815),set(1082,3295),set(1186,1267),set(1006,740),
	 * get(846),set(1024,1853),set(1135,520),get(109),set(453,2115),set(121,2625
	 * ),set(675,1742),get(792),get(1070),set(838,1795),set(870,718),get(1337),
	 * set(164,19),set(778,56),get(761),get(1409),get(229),set(679,2702),get(
	 * 1142),get(917),set(552,1393),get(1388),set(63,2021),set(164,372),set(622,
	 * 2080),set(1335,118),set(1014,2677),set(901,2487),get(845),set(1002,246),
	 * get(936),set(541,2433),set(1296,282),set(254,2276),get(1088),set(417,87),
	 * get(432),set(746,2022),set(1059,542),get(1195),get(324),set(1301,1944),
	 * set(1154,2464),set(689,1457),get(932),get(54),get(52),get(112),set(1240,
	 * 2436),set(234,2088),get(1395),get(1176),set(301,3173),get(1022),set(59,
	 * 692),set(1356,727),set(122,709),get(1138),set(38,111),get(1402),set(27,
	 * 425),get(1380),set(953,3009),get(452),set(938,96),get(339),get(668),set(
	 * 1330,1933),get(1253),set(998,127),set(1139,883),set(164,274),set(1036,
	 * 1945),get(18),get(815),set(1327,1928),set(365,89),set(772,3197),set(552,
	 * 545),get(398),get(54),set(146,2445),get(767),set(493,3113),get(524),get(
	 * 1074),get(1304),set(545,667),set(836,3299),set(342,3265),get(1429),get(
	 * 1271),set(1143,840),get(202),set(611,1689),set(850,335),get(1182),get(807
	 * ),get(243),get(504),get(1107),get(684),get(607),get(515),get(995),set(195
	 * ,2190),set(26,565),set(719,2142),set(1122,2326),set(1400,1028),set(142,
	 * 486),set(203,1181),set(939,186),get(41),set(113,2438),set(138,750),get(
	 * 1007),get(285),get(212),get(943),get(492),set(1342,1475),set(1313,1394),
	 * get(548),set(828,1027),set(1390,2929),set(1023,2914),get(1024),get(945),
	 * get(171),get(1140),set(817,2039),set(25,2185),get(276),set(976,2254),set(
	 * 138,3030),set(221,271),get(721),set(23,738),set(392,2088),get(466),get(
	 * 1181),set(574,1601),set(1354,1318),get(1235),set(182,2085),set(111,2801),
	 * set(137,2159),get(24),get(558),get(814),get(602),set(1154,1284),set(403,
	 * 2147),set(441,1860),set(536,605),get(819),get(134),set(305,782),set(1291,
	 * 2869),set(1407,421),get(664),get(916),get(521),get(873),get(725),set(456,
	 * 2983),get(868),set(818,284),get(421),get(26),set(1259,289),get(557),get(
	 * 503),set(82,1284),set(853,2847),get(290),get(584),set(818,50),get(770),
	 * set(666,1015),get(1430),set(1312,2519),set(1015,138),get(283),set(29,1607
	 * ),set(1358,2511),get(763),get(344),set(1065,2481),get(581),get(37),get(
	 * 173),set(199,1888),set(447,2731),set(1385,765),set(658,569),get(1186),set
	 * (804,1702),set(212,1993),set(836,2893),set(647,2564),set(1007,1981),set(
	 * 1314,2143),set(1099,1813),set(414,786),set(1130,1069),get(1387),set(85,
	 * 3025),set(596,435),get(644),get(1342),set(785,288),set(1193,2933),get(849
	 * ),set(1005,1739),get(822),set(1328,2154),set(443,1414),set(573,2925),get(
	 * 153),get(1268),set(180,815),set(654,686),set(672,588),set(1231,2850),get(
	 * 542),get(1173),set(666,2584),get(1298),get(553),get(717),set(168,592),set
	 * (936,2669),get(782),set(1364,2102),set(489,802),get(1389),get(413),get(
	 * 605),get(1025),get(793),set(627,1659),set(1088,512),get(328),set(355,893)
	 * ,get(1373),get(540),get(715),set(603,1059),set(1358,640),get(580),get(327
	 * ),set(485,915),set(1242,1206),set(1048,659),set(402,1766),get(959),set(
	 * 1147,690),get(1177),set(1120,3253),set(789,229),set(1250,2139),set(862,
	 * 255),set(915,776),set(1237,1764),get(746),set(340,2074),get(1415),set(811
	 * ,1219),set(27,2701),get(131),set(952,3197),set(93,2707),set(87,1845),set(
	 * 504,2750),get(838),get(456),set(1406,247),set(1057,2628),set(1337,112),
	 * set(282,1093),set(407,1362),set(1409,493),get(220),get(576),set(1140,719)
	 * ,get(1196),set(152,1910),get(788),set(205,2842),set(1136,2731),set(1032,
	 * 2539),get(604),set(284,782),get(735),set(232,2797),get(225),get(516),get(
	 * 1170),set(83,1909),set(441,2302),get(1169),get(181),get(289),get(1361),
	 * set(252,2072),set(600,541),get(1115),set(1080,360),set(1223,1863),set(715
	 * ,1613),get(313),set(1307,1392),get(1128),set(1292,1698),get(898),set(364,
	 * 840),get(31),get(269),set(1302,244),set(1074,2207),get(660),set(1241,2074
	 * ),get(780),get(142),get(1316),get(146),set(926,1086),set(1136,3157),set(
	 * 785,2569),get(1220),get(106),set(1382,1534),get(65),get(1278),set(895,695
	 * ),set(1267,1128),set(126,1710),get(926),get(38),set(489,139),set(555,926)
	 * ,set(911,928),set(349,1284),set(1363,1875),get(1423),set(1190,1227),set(
	 * 101,736),set(477,2410),set(1168,626),get(697),set(1209,1751),get(1103),
	 * get(734),get(968),get(918),set(900,1506),set(820,579),get(567),set(39,
	 * 3190),set(1358,352),get(88),set(735,1229),set(193,820),get(1142),set(937,
	 * 3238),set(1091,1301),set(1147,873),set(1246,366),set(1359,40),get(839),
	 * get(1210),set(1058,878),set(1404,339),set(125,904),get(402),get(907),set(
	 * 408,3015),get(1194),set(306,540),set(658,1997),get(288),set(482,736),get(
	 * 193),set(1169,645),set(446,740),get(1095),get(1215),set(874,788),get(1387
	 * ),set(951,3175),get(368),set(605,1234),set(718,564),set(912,101),set(730,
	 * 28),get(1240),set(582,972),set(278,3259),set(403,1902),get(398),set(979,
	 * 1574),set(375,1770),set(318,584),set(887,3243),get(979),get(532),set(832,
	 * 1836),set(402,1272),get(424),get(846),set(1050,2405),get(1149),get(1081),
	 * get(746),set(605,1679),get(902),set(802,1455),set(1142,333),get(1092),get
	 * (620),set(800,2016),get(253),get(1214),get(923),set(1403,1890),set(563,
	 * 919),set(110,1794),set(333,3046),get(1061),get(414),set(897,2790),get(372
	 * ),get(712),get(765),set(286,1254),set(112,74),set(933,1577),set(820,1062)
	 * ,set(42,1779),set(1351,1669),set(1195,104),set(803,307),get(238),get(1293
	 * ),set(21,127),get(106),set(113,1418),get(193),get(1101),set(164,1580),set
	 * (1302,895),get(228),get(600),set(1190,2999),set(681,327),get(420),set(643
	 * ,826),set(383,1859),get(338),set(974,407),set(986,536),set(261,3266),get(
	 * 792),get(1320),get(162),get(1076),get(1067),set(197,540),set(259,2727),
	 * get(506),set(223,152),set(1147,880),set(1206,1654),get(1320),get(1030),
	 * get(1415),set(387,2267),set(866,56),get(484),set(857,1528),set(650,2430),
	 * set(148,60),get(1114),get(378),set(750,647),get(488),get(1318),set(932,
	 * 851),get(1225),set(1147,2752),set(1115,1203),get(1125),get(285),get(536),
	 * set(1042,2167),set(583,1897),set(1214,2125),set(352,1236),set(107,756),
	 * set(306,1261),set(240,730),get(1174),set(26,823),set(979,1863),get(618),
	 * set(1360,1940),set(792,882),get(837),get(1109),set(235,1974),get(826),set
	 * (771,1243),set(1088,1916),get(1178),set(879,2987),set(688,1604),get(845),
	 * get(1330),get(583),get(133),set(1190,672),get(442),get(201),set(1368,3253
	 * ),get(459),set(721,1258),set(1093,2329),get(391),get(588),get(1070),get(
	 * 518),set(1123,817),get(470),get(748),get(266),set(1209,2618),set(259,3192
	 * ),get(131),set(22,2289),get(98),set(1248,823),set(1345,2526),get(1312),
	 * set(1003,1324),set(1238,633),set(736,2826),get(662),set(1369,451),set(240
	 * ,2514),set(205,1905),set(747,2060),get(1165),set(926,839),get(1183),set(
	 * 635,3183),get(655),set(1060,1068),set(560,369),get(1159),get(1079),get(
	 * 356),set(473,1802),set(973,448),get(942),set(390,1930),set(26,1513),set(
	 * 227,1982),set(140,2283),set(502,559),set(1413,58),set(1266,1316),set(1280
	 * ,666),set(824,310),get(983),set(200,2017),set(540,357),get(311),get(813),
	 * get(1230),get(747),get(1344),set(302,2006),set(1346,379),set(578,1219),
	 * get(851),get(319),set(250,216),set(1339,3296),set(825,2072),set(1219,3151
	 * ),set(256,667),set(132,3006),set(1113,766),set(460,3219),set(607,109),get
	 * (1357),set(1209,1317),set(155,402),set(834,1737),get(1257),set(341,6),get
	 * (928),get(302),set(526,973),get(76),get(337),get(931),set(1277,1870),set(
	 * 235,1750),get(923),get(1225),set(471,455),set(933,1157),set(363,1355),get
	 * (697),set(1279,1516),set(1380,1920),set(1020,1263),get(1406),get(359),get
	 * (311),get(615),set(1088,1835),get(234),set(1033,1381),set(227,1244),set(
	 * 551,1774),set(1268,915),get(823),set(900,2556),set(843,221),set(116,2246)
	 * ,get(782),get(158),set(789,1909),set(893,1185),set(209,246),set(1181,3117
	 * ),get(141),set(1161,2553),set(585,2099),get(256),set(177,3182),get(786),
	 * set(1207,824),set(1119,2653),set(405,2730),set(17,1901),set(374,95),get(
	 * 658),get(234),set(829,2149),set(1034,1931),get(78),get(968),set(379,2565)
	 * ,set(374,3191),set(1175,190),get(1173),set(105,1993),get(567),set(887,
	 * 2963),set(138,2129),set(272,2382),set(610,1066),set(839,1956),set(1388,
	 * 162),set(993,559),set(150,532),get(84),set(79,2906),get(800),set(46,3146)
	 * ,get(302),set(1266,163),set(1316,337),get(1319),set(1117,3143),set(975,
	 * 439),set(895,1486),set(716,3183),get(841),set(962,1537),get(876),set(908,
	 * 1743),set(678,1680),set(472,829),set(1339,1631),set(951,1767),set(558,400
	 * ),set(96,441),set(565,1943),get(1054),get(457),get(189),set(864,3108),get
	 * (1325),get(825),get(261),get(712),set(739,1335),get(606),set(1173,1232),
	 * get(1055),get(1263),get(429),set(1413,1503),set(1127,3052),set(766,2478),
	 * set(540,510),set(750,240),get(964),set(1210,2194),get(1072),set(12,548),
	 * set(1294,1151),get(548),get(1109),get(1427),set(827,1828),set(449,2513),
	 * set(1376,2104),get(1063),get(513),get(133),set(194,3105),get(525),set(
	 * 1266,2403),get(356),get(78),set(917,1982),get(212),get(1175),set(668,2577
	 * ),get(534),set(986,1528),get(782),set(461,2133),set(537,948),get(237),get
	 * (194),set(1086,2460),set(327,1103),set(345,2167),get(372),get(953),set(
	 * 989,86),get(1119),set(906,1961),set(235,1678),get(671),get(1073),get(105)
	 * ,set(1015,2381),get(1270),get(701),set(46,265),get(243),set(14,2095),get(
	 * 868),get(46),get(1315),get(149),set(121,717),set(710,383),set(362,3010),
	 * set(595,1447),get(1293),set(503,2363),get(733),set(563,2688),set(1115,
	 * 2045),set(1287,1951),get(1125),set(1295,2597),set(39,151),set(355,86),get
	 * (250),set(1026,2603),set(290,2728),set(1297,606),get(888),set(408,2191),
	 * set(993,260),set(26,883),set(352,1338),set(784,904),get(787),get(527),set
	 * (569,2858),get(1211),get(801),set(1089,2004),get(817),set(801,2199),set(
	 * 554,1423),get(1293),set(942,219),set(906,1623),get(319),set(1150,1147),
	 * set(354,2896),get(133),get(1054),get(293),set(723,1899),set(462,595),set(
	 * 797,1674),get(1236),get(1047),set(731,27),get(1223),set(166,1739),set(
	 * 1243,966),set(814,461),get(23),get(219),set(575,3282),set(909,2809),get(
	 * 878),get(1393),set(274,1210),set(704,673),set(937,2932),set(836,2315),get
	 * (1103),get(1306),set(99,2292),get(197),set(1259,809),set(1139,2337),get(
	 * 1076),set(292,1849),get(1092),get(317),set(1402,659),set(1074,170),set(
	 * 812,946),get(364),get(1050),set(471,286),set(1126,1378),get(951),get(717)
	 * ,get(1160),set(1090,2280),set(1212,515),set(1377,1358),set(560,940),set(
	 * 1064,2937),set(343,2194),set(947,1100),get(261),get(767),set(1321,2386),
	 * get(225),set(756,2362),set(999,1071),set(241,1120),set(1232,624),set(1012
	 * ,458),get(1128),set(1386,2956),set(549,1144),set(495,1987),get(513),set(
	 * 118,2278),get(920),get(172),set(315,2246),get(321),set(61,1696),set(460,
	 * 1094),set(26,1921),get(1123),set(306,466),get(836),set(347,1789),get(525)
	 * ,get(1199),get(21),set(906,2197),set(7,3251),get(1109),get(488),set(445,
	 * 1971),get(1248),set(350,275),set(504,3133),get(1224),set(324,2742),get(
	 * 191),get(820),set(407,1259),set(115,1432),get(992),get(219),set(236,1190)
	 * ,set(841,1724),set(807,3197),get(146),set(355,1747),get(816),set(926,1082
	 * ),get(111),set(168,1494),set(426,3029),set(256,26),set(1147,3079),set(
	 * 1098,1036),get(134),get(1413),set(1092,1099),get(947),get(720),get(1309),
	 * set(958,519),set(1227,829),get(204),get(233),get(1143),set(757,2463),get(
	 * 710),set(864,862),set(733,2920),set(961,2333),set(708,1677),get(580),set(
	 * 1138,379),set(345,96),set(164,2361),set(461,2189),set(724,2808),set(1350,
	 * 201),set(445,2483),get(262),set(1299,2016),get(727),set(1048,1604),set(
	 * 1278,951),set(390,1092),set(575,583),get(1282),get(839),set(908,3063),set
	 * (2,1579),get(1324),set(404,1509),get(281),get(1064),get(575),get(1126),
	 * set(922,1966),set(476,357),set(749,3001),set(819,1715),get(483),set(36,
	 * 2648),set(126,1984),get(1338),get(1146),get(742),get(1247),set(1323,1385)
	 * ,get(379),set(1312,2385),get(1308),set(6,2663),set(856,2957),set(121,221)
	 * ,set(513,2887),get(756),set(224,1917),set(486,1016),set(268,1084),set(
	 * 1204,739),get(1192),get(776),get(292),set(371,1254),get(161),set(950,1824
	 * ),get(31),get(538),set(1070,3208),set(1293,3186),get(50),set(88,2287),set
	 * (422,710),get(1393),set(524,2129),get(271),set(971,1745),get(1231),get(
	 * 1363),set(375,3066),get(866),set(319,1173),set(64,632),set(968,2107),set(
	 * 447,1944),set(749,2942),set(1252,1688),get(465),get(122),set(1373,207),
	 * set(600,2907),set(947,11),get(1213),get(1095),get(403),get(1217),set(434,
	 * 965),get(862),get(1388),get(1318),set(1072,1770),set(938,2999),get(1150),
	 * get(1196),get(596),set(1039,2197),get(163),set(926,634),set(664,587),set(
	 * 1147,2875),set(829,60),set(410,3122),set(168,2910),set(893,2941),get(1029
	 * ),set(584,1387),set(96,103),get(133),get(790),get(1184),get(821),get(1014
	 * ),set(965,489),get(137),get(1123),set(838,971),set(763,2952),set(328,1377
	 * ),set(433,2741),get(568),set(498,1493),get(394),get(1253),set(1425,159),
	 * set(1203,3146),set(1137,1279),set(571,81),get(1007),get(1030),set(739,
	 * 2140),set(749,1128),set(1070,1096),get(1250),get(1230),get(968),get(240),
	 * get(1048),get(115),set(352,1092),set(98,2656),set(672,2757),get(326),set(
	 * 1054,3260),set(161,2328),set(1088,1547),get(182),set(322,1018),get(385),
	 * set(1193,1512),get(581),set(619,3255),set(1400,2408),set(592,2864),set(
	 * 466,1035),set(1336,2970),set(43,1797),get(1097),set(1248,1606),get(261),
	 * set(722,635),get(532),set(1398,258),set(994,1149),set(1216,2582),get(100)
	 * ,set(1122,2458),set(526,444),get(354),set(1002,1638),set(604,1457),set(
	 * 1298,857),set(1346,3105),set(848,1417),get(628),set(948,1926),set(1143,
	 * 608),set(920,2982),set(486,3237),set(183,1269),get(869),set(741,3023),set
	 * (1107,2391),set(834,319),get(1278),set(1072,1997),set(1283,2909),get(667)
	 * ,set(1052,767),get(702),get(1335),get(227),get(965),set(170,1490),set(630
	 * ,2432),get(593),get(1398),set(1065,3096),set(1163,2605),set(119,1472),get
	 * (344),set(1009,2342),get(5),get(394),set(688,2146),set(488,2820),get(810)
	 * ,set(1046,355),set(143,1304),get(748),set(276,2681),get(1352),get(102),
	 * set(43,1152),set(1143,1180),get(345),get(67),set(543,2127),set(448,3007),
	 * set(1113,2194),get(488),get(567),set(831,874),set(1154,720),get(982),set(
	 * 1152,2015),set(47,257),set(1163,1699),set(1074,2498),set(1252,2170),get(
	 * 1361),set(412,2078),set(45,406),set(1218,421),get(567),set(256,140),get(
	 * 45),get(1162),get(679),set(422,1590),set(282,2600),get(519),set(231,1675)
	 * ,get(1007),get(1347),get(382),set(1160,1966),get(1198),set(352,2721),get(
	 * 1201),set(501,1268),set(1333,3151),get(256),set(13,2476),get(300),set(957
	 * ,2051),get(792),get(1164),get(1370),get(64),get(366),set(323,108),set(951
	 * ,411),set(413,2087),get(983),set(502,3263),get(1302),get(852),set(882,
	 * 2044),set(316,2777),get(822),get(154),get(673),set(524,468),get(1191),get
	 * (518),set(879,444),get(521),get(985),get(602),get(232),get(853),set(206,
	 * 520),set(715,2852),get(410),get(396),set(626,736),set(1428,1042),set(396,
	 * 2278),get(860),set(505,1992),get(1094),set(1386,2097),set(1092,801),set(
	 * 273,2238),get(116),set(324,1455),get(1264),set(178,65),get(82),set(914,
	 * 423),set(9,2408),get(569),get(882),get(846),get(483),set(401,434),set(702
	 * ,2505),get(437),get(572),set(278,1484),set(683,1635),get(1273),set(926,
	 * 1800),get(726),set(705,404),set(618,2781),set(149,1032),set(875,483),set(
	 * 871,2735),get(582),set(1316,1492),set(1387,1336),get(907),get(1110),set(
	 * 267,3223),set(250,3275),set(650,545),get(913),set(456,1928),set(216,660),
	 * set(200,2380),get(927),get(373),set(1181,1145),get(1055),set(971,1939),
	 * get(644),set(392,467),set(930,41),get(552),get(1055),set(448,668),get(556
	 * ),set(700,1962),set(251,3167),get(1346),get(404),set(181,676),set(843,772
	 * ),get(736),set(743,711),get(1153),set(318,546),get(1352),set(70,3071),set
	 * (662,1198),get(82),get(1228),set(1377,130),get(661),get(341),get(202),set
	 * (1207,3164),get(1387),get(1186),set(618,1103),set(876,1200),set(356,1868)
	 * ,get(1023),set(717,2769),set(1176,1616),set(1404,122),set(837,1534),get(
	 * 659),set(715,3),get(299),set(702,2894),get(17),set(447,256),set(502,2369)
	 * ,get(136),get(565),get(262),get(88),set(452,1224),get(956),set(452,3271),
	 * set(619,1244),set(1082,425),set(435,1564),get(887),get(304),set(446,1511)
	 * ,get(259),set(702,1124),get(322),get(1199),set(239,1148),set(1421,3101),
	 * set(1367,68),set(399,2754),get(16),set(867,868),get(97),get(310),set(1281
	 * ,1136),get(1427),set(499,1087),set(123,3252),set(423,68),set(112,349),set
	 * (104,1283),get(626),set(1398,1195),set(448,2351),get(277),set(1018,835),
	 * set(559,60),set(117,1667),get(164),set(323,2678),get(866),get(142),set(
	 * 371,938),get(1231),get(1041),set(720,403),set(1205,154),set(779,2561),get
	 * (347),get(632),set(858,3261),set(1055,1782),get(846),get(1179),get(691),
	 * get(260),set(908,1993),get(1128),get(83),get(1086),get(741),get(641),set(
	 * 884,1020),set(134,1060),get(552),set(845,2891),get(45),get(684),set(244,
	 * 1398),set(922,2514),get(1077),set(594,828),get(584),get(368),set(424,391)
	 * ,set(47,1057),get(329),set(505,1639),set(114,96),set(1070,2527),set(111,
	 * 2234),get(533),set(1216,1540),get(1250),get(1134),set(486,3040),get(587),
	 * set(1102,1925),get(321),get(596),get(1358),set(1279,269),set(1284,704),
	 * set(696,2495),set(679,2383),set(411,343),get(381),set(46,2558),set(961,
	 * 2547),get(1147),get(741),set(630,3052),set(680,1115),set(100,2),set(765,
	 * 842),set(571,2426),get(626),get(534),get(972),get(1208),get(1181),set(633
	 * ,1611),set(801,3114),set(55,1201),get(1299),get(1012),get(1295),get(380),
	 * get(1261),get(552),get(1025),get(300),set(914,2361),set(10,1806),set(350,
	 * 2627),get(1177),set(1164,338),get(42),set(141,2128),get(1153),get(695),
	 * get(693),set(1268,3002),set(1059,614),set(1053,1707),set(1410,504),get(
	 * 1238),set(949,461),get(440),get(1325),get(1136),set(838,3156),get(494),
	 * set(85,263),set(1411,1550),set(445,592),set(824,491),get(541),set(541,420
	 * ),set(841,2463),get(328),set(301,2801),set(810,1737),set(491,820),set(
	 * 1139,1526),get(1113),set(705,3127),set(381,2480),set(75,2998),set(17,1072
	 * ),get(369),set(1243,2299),get(902),set(1186,2673),set(710,413),get(799),
	 * get(732),get(547),set(590,1038),get(140),set(1252,1907),get(1166),set(691
	 * ,2500),set(1339,1557),set(491,2243),get(314),get(397),set(1143,2247),set(
	 * 1378,2304),set(240,2148),set(923,820),get(200),get(534),get(29),set(261,
	 * 2154),set(1334,1027),set(725,2503),set(103,1853),get(288),get(554),set(
	 * 495,2011),get(31),get(285),set(112,2273),set(206,359),get(1359),get(1231)
	 * ,get(1312),set(530,2511),get(897),set(1269,1887),set(951,1678),get(1348),
	 * set(1284,3142),set(926,623),set(677,3007),get(1211),set(1337,1162),set(
	 * 1359,482),get(608),get(1367),set(941,2979),get(367),get(1223),get(1027),
	 * set(1312,2057),get(536),set(386,3240),set(115,917),set(574,2561),get(296)
	 * ,get(1385),set(1128,1002),get(1088),set(1004,2401),set(970,1431),set(503,
	 * 1012),get(413),set(83,871),set(648,242),set(3,803),set(1250,982),set(1304
	 * ,2484),set(1343,2940),get(1142),get(1320),get(920),set(441,1336),set(761,
	 * 942),get(1309),get(634),get(313),get(683),set(669,1968),get(839),get(1250
	 * ),set(1022,2635),get(219),get(384),get(224),set(856,1190),get(472),get(
	 * 639),set(241,512),set(869,1436),set(589,223),set(288,531),get(37),get(660
	 * ),get(138),set(116,2064),get(777),set(179,521),get(1249),set(840,1048),
	 * set(757,521),set(952,1869),get(1326),get(705),set(450,945),set(587,355),
	 * get(440),set(1077,2068),get(375),get(427),set(1269,3254),set(257,3301),
	 * get(900),get(542),set(1232,518),get(1073),get(38),get(806),get(511),set(
	 * 421,1617),get(938),get(985),get(670),get(424),get(540),set(316,445),set(
	 * 141,524),get(32),set(953,1227),set(27,2760),set(153,1581),set(583,1100),
	 * set(1374,1348),get(577),set(1057,2855),set(428,1472),set(624,2835),set(
	 * 843,22),get(537),set(784,766),set(936,1087),set(232,2569),set(149,1493),
	 * set(565,2327),set(327,1593),set(1300,1868),set(54,569),get(739),get(640),
	 * set(426,715),set(1297,2214),set(1305,708),get(1122),get(256),set(224,1108
	 * ),get(493),get(638),get(205),set(759,444),get(1004),get(347),set(1013,
	 * 2773),set(964,2375),get(1309),get(1136),set(670,2973),set(893,411),get(69
	 * ),get(532),set(564,210),set(1056,2031),get(1346),get(59),get(927),get(206
	 * ),set(172,193),get(1396),get(915),set(889,1024),set(69,2397),get(31),get(
	 * 55),set(785,2444),set(1093,950),get(629),get(1240),set(592,1628),set(1337
	 * ,1965),get(714),set(934,2913),set(1007,2907),set(429,2380),set(784,3211),
	 * get(877),set(329,2028),get(1385),set(1250,128),set(264,897),set(1076,47),
	 * get(251),get(442),set(389,1222),set(1042,2795),get(1238),set(907,2663),
	 * set(804,73),set(1251,2509),get(1082),get(372),set(165,2390),set(1232,3184
	 * ),set(855,212),set(52,1183),set(928,1798),get(204),set(1357,1966),set(
	 * 1360,1041),set(964,1103),get(988),get(410),set(968,2463),get(1002),set(
	 * 1418,1886),set(413,3070),get(193),get(256),set(270,679),get(1188),get(
	 * 1145),set(16,191),get(576),set(1154,2598),set(1068,1785),get(1154),get(
	 * 868),get(995),set(675,20),get(646),set(1395,561),get(1273),get(550),get(
	 * 525),set(1371,2454),get(1305),set(553,2461),set(1389,1564),set(152,2080),
	 * set(649,1895),set(113,1610),set(242,2495),set(1077,1952),set(182,2595),
	 * get(475),set(458,105),get(890),get(488),set(651,1282),set(1096,2277),get(
	 * 245),get(559),set(221,1936),set(977,177),set(541,2196),set(653,2954),set(
	 * 1188,3298),get(507),get(421),get(337),get(32),get(293),set(689,2211),set(
	 * 207,3068),set(252,190),get(1288),get(710),set(954,2552),get(943),set(712,
	 * 661),get(248),get(490),set(552,585),get(1009),get(795),set(65,2717),set(
	 * 1422,442),get(163),set(357,905),get(996),get(374),set(1426,631),get(830),
	 * set(95,2723),set(1224,3059),get(1309),get(1120),get(846),set(1284,888),
	 * get(391),get(733),get(297),set(606,1819),set(117,630),get(908),set(244,
	 * 797),set(508,1448),set(806,2909),get(1109),set(98,812),set(979,3201),get(
	 * 1248),get(1400),set(1341,15),set(109,2682),set(416,1051),set(556,2751),
	 * get(1017),set(561,2406),set(909,2023),set(288,31),set(478,1264),set(652,
	 * 1262),get(717),get(888),get(425),get(578),set(573,1746),get(818),get(414)
	 * ,get(556),set(1240,2333),get(299),set(45,87),set(1211,1195),get(834),set(
	 * 114,2470),get(473),get(738),get(749),get(756),get(128),get(655),get(25),
	 * set(293,1981),set(569,886),get(315),set(327,566),get(1205),set(894,1877),
	 * get(142),get(1056),get(1002),get(550),get(825),get(696),get(490),get(149)
	 * ,set(841,3040),get(705),get(1058),set(162,2051),set(936,3214),get(667),
	 * set(1292,2286),set(598,1924),set(1245,256),set(159,1959),set(1332,1309),
	 * set(344,1555),set(506,1947),set(495,2203),set(954,1929),get(185),get(1095
	 * ),get(481),set(1048,2419),get(703),set(1007,1395),set(1241,288),get(1297)
	 * ,set(327,2076),get(285),set(1234,46),set(223,1803),set(524,1715),get(464)
	 * ,get(582),set(544,2095),set(158,1175),get(1246),set(485,2238),get(856),
	 * set(1110,1134),get(945),set(1224,2932),set(377,1012),set(920,1505),set(
	 * 536,2299),get(396),get(90),set(879,163),set(988,2921),get(451),set(1237,
	 * 1305),get(1100),set(510,2760),set(467,2665),get(1235),get(57),set(1182,
	 * 1296),get(492),set(114,500),get(211),set(231,2691),get(332),set(1039,70),
	 * set(630,1752),get(1143),set(582,2762),get(505),set(250,2376),get(1272),
	 * set(618,876),set(534,2208),get(636),get(249),set(1031,842),get(441),set(
	 * 489,624),get(166),set(473,1243),set(524,2028),set(218,2801),set(1355,2801
	 * ),set(1173,600),set(976,561),set(628,979),set(1193,2945),get(360),set(362
	 * ,613),get(874),get(1254),set(1396,2475),set(30,404),get(532),get(174),set
	 * (1249,735),get(603),get(105),get(1196),set(1031,2978),set(1126,3021),set(
	 * 130,1904),set(1208,2947),set(125,2220),get(233),get(1296),set(1392,1937),
	 * set(245,955),set(622,2626),get(547),set(548,1667),set(1098,1819),get(648)
	 * ,set(950,1010),get(713),set(964,1093),get(1313),get(928),set(142,1708),
	 * set(755,593),get(1000),set(1299,2401),get(1379),set(640,3230),set(306,508
	 * ),get(1186),set(498,44),set(272,1481),get(1106),get(1081),set(104,2757),
	 * set(1039,898),set(967,3278),set(645,1030),set(124,151),set(898,1040),set(
	 * 709,874),get(807),set(38,1462),set(731,2513),set(1175,2548),set(267,677),
	 * set(960,138),set(427,595),get(805),set(1388,2578),get(977),set(763,2471),
	 * set(598,786),set(375,1345),set(156,3117),set(255,2845),get(267),get(633),
	 * get(439),set(374,555),set(350,2728),get(350),set(183,2642),get(46),get(14
	 * ),get(1087),set(724,1227),get(1084),set(1178,1204),set(605,3221),set(806,
	 * 195),set(848,3011),get(976),set(74,2371),set(392,798),get(963),set(835,
	 * 2248),get(189),set(208,330),get(1050),set(448,422),set(794,608),set(986,
	 * 3270),get(1250),set(1128,1129),set(1358,2682),set(1250,2243),get(352),set
	 * (339,311),set(1098,1015),get(361),get(230),set(809,2376),get(223),set(
	 * 1019,1695),get(1142),get(91),get(711),set(805,1423),set(760,480),get(671)
	 * ,set(705,549),set(1287,3164),set(1297,1382),set(1279,1012),set(1425,616),
	 * set(100,1814),set(1106,14),set(141,2181),set(1208,413),set(296,2086),set(
	 * 34,2086),get(743),set(1222,1773),set(104,479),get(1164),get(778),set(1333
	 * ,2846),set(140,1244),get(206),get(1399),set(1365,441),set(487,1056),set(
	 * 1222,2361),get(153),set(313,552),set(738,1195),set(1062,1760),get(1398),
	 * get(690),set(86,2542),get(667),set(194,614),get(259),set(835,1586),set(
	 * 390,2224),set(265,610),set(1111,657),set(223,2015),get(309),set(1285,830)
	 * ,set(1057,1601),get(364),get(505),set(678,3083),set(1423,760),set(527,33)
	 * ,set(1210,176),set(1107,1304),get(620),get(1412),set(1337,1800),get(1296)
	 * ,set(336,1702),get(605),get(576),set(1359,2553),get(429),set(928,2142),
	 * set(405,1517),set(79,2079),set(589,1290),set(630,969),get(422),get(1104),
	 * get(1063),set(1189,1035),get(1026),get(1367),get(103),set(118,1116),set(
	 * 13,1120),get(1300),get(749),get(115),set(612,2692),set(1202,1192),get(
	 * 1163),get(851),get(412),get(583),set(1145,2415),get(1149),set(149,2764),
	 * get(258),set(391,1880),set(1273,3262),get(331),get(314),get(433),get(352)
	 * ,get(421),get(454),get(301),get(497),set(1167,189),get(1087),set(286,1789
	 * ),set(659,2845),get(407),get(327),get(1217),get(1091),set(47,737),set(
	 * 1038,1942),set(423,3273),set(670,2537),get(1054),get(807),set(930,1244),
	 * set(1109,2654),set(921,2639),set(730,1590),get(553),set(29,2697),get(1036
	 * ),set(1332,715),get(1209),get(255),get(1187),get(1111),get(407),get(487),
	 * get(406),set(582,1621),set(1286,2626),set(21,1357),set(1189,2299),get(564
	 * ),get(1398),get(548),set(133,1027),set(971,734),get(732),set(957,2896),
	 * set(679,2361),set(885,703),get(1295),set(1333,3289),set(586,3115),set(124
	 * ,2056),get(1080),set(189,2144),set(813,1399),set(1222,2202),set(694,658),
	 * set(1237,1708),get(1025),get(1194),set(1116,2346),get(1311),set(1104,2624
	 * ),set(1289,3046),set(1155,310),set(396,968),get(346),set(655,1297),set(
	 * 782,1370),get(38),get(531),get(657),set(1196,1958),set(1074,375),set(59,
	 * 941),get(985),set(578,3057),get(774),get(1086),set(66,1221),get(650),set(
	 * 299,1554),get(875),set(736,1478),set(1172,1286),set(536,465),get(1200),
	 * set(1074,2314),get(964),set(1003,1488),set(1278,2336),get(1049),set(628,
	 * 1975),set(50,2846),set(155,3165),set(8,488),set(574,2699),set(400,786),
	 * set(15,45),get(459),get(298),get(225),set(1092,2970),get(269),get(1364),
	 * get(1048),get(118),get(403),set(1185,1882),get(441),set(146,654),get(528)
	 * ,get(995),get(125),set(380,1130),get(337),get(617),set(332,125),get(570),
	 * set(1265,231),set(1023,2925),set(44,3022),set(1347,2485),set(475,2545),
	 * set(1198,164),get(1309),set(1007,3006),get(1297),set(660,2830),set(542,
	 * 714),get(1025),set(1235,1835),set(1320,1259),get(1250),set(294,1508),set(
	 * 418,1751),get(535),get(812),set(908,1693),set(759,2896),get(366),set(1379
	 * ,2658),set(877,2852),set(924,1707),get(958),get(820),set(780,1385),set(
	 * 946,2908),set(422,297),set(1038,2041),set(842,1430),get(943),set(1220,
	 * 1626),set(1176,2536),set(1417,1745),set(711,289),set(766,1178),set(53,
	 * 2960),set(705,2712),get(143),set(492,96),set(744,1579),set(1114,1148),set
	 * (190,951),set(923,2217),get(1411),set(84,1029),set(1263,3117),set(948,132
	 * ),set(1206,3176),set(726,888),get(817),set(636,2106),set(1127,848),set(
	 * 885,1930),set(515,2598),set(1008,627),get(388),get(916),set(554,2478),set
	 * (79,647),get(801),set(527,511),set(550,2819),set(669,771),set(1400,3164),
	 * get(1080),get(365),get(674),get(389),get(574),set(227,1240),set(1299,1598
	 * ),get(126),set(1286,914),set(1130,618),set(166,1136),get(948),set(311,824
	 * ),get(1),set(1068,885),get(693),get(47),get(1183),set(509,978),set(93,119
	 * ),get(534),set(1305,429),set(799,3012),set(243,803),get(802),set(323,1265
	 * ),set(258,2963),set(249,2374),get(1253),get(1269),get(331),set(326,2445),
	 * get(653),set(163,1945),set(595,2316),set(1080,1565),get(142),set(898,3138
	 * ),set(1174,2556),get(279),set(1153,977),set(420,1059),get(896),get(113),
	 * get(508),get(325),get(1117),set(1342,1585),set(1123,2751),get(525),get(
	 * 331),get(479),get(1037),set(571,367),set(301,2755),get(993),get(476),set(
	 * 1219,2860),set(991,9),get(127),set(285,2609),set(450,644),set(177,907),
	 * set(368,1362),get(160),set(699,2879),set(690,2237),set(960,1899),set(87,
	 * 2690),set(91,185),set(527,1508),set(1343,1378),get(233),set(1313,217),set
	 * (6,3252),set(433,425),set(1418,701),set(106,525),set(177,2230),get(373),
	 * set(1221,1826),set(834,2799),set(1029,1706),get(95),get(1277),set(621,5),
	 * set(884,250),set(1313,2234),set(619,3303),get(29),set(1312,1733),set(911,
	 * 1451),set(1243,2199),get(538),set(590,2188),set(1272,514),set(172,2655),
	 * get(1298),set(406,1813),get(893),get(482),set(427,1767),set(275,2652),get
	 * (900),set(853,1802),get(554),get(275),get(1376),set(267,2281),get(111),
	 * get(598),set(365,1911),set(376,829),get(1182),get(1112),get(967),get(103)
	 * ,get(529),set(1296,2518),get(1105),set(1218,2971),get(1046),set(459,1712)
	 * ,set(1127,2488),get(197),set(1160,48),get(1142),set(783,2955),set(672,
	 * 1281),set(1102,2122),set(1398,245),get(1015),get(606),set(603,2200),set(8
	 * ,1395),get(1405),set(881,1159),get(1179),get(921),set(1373,3006),get(1413
	 * ),set(1070,1430),set(791,1894),get(1421),get(1035),set(277,2107),get(837)
	 * ,get(193),set(473,3084),set(1335,3192),get(18),set(1430,1378),set(894,
	 * 3233),set(903,2535),get(573),get(797),set(656,2580),get(853),get(605),get
	 * (312),set(930,2780),set(325,1430),set(924,936),set(241,2087),set(502,2084
	 * ),get(478),set(546,2920),get(989),set(82,889),set(471,427),get(1026),get(
	 * 422),get(759),set(1336,579),set(211,2147),get(1390),set(549,1382),get(165
	 * ),set(1382,375),get(436),get(879),set(1333,456),get(135),get(1342),set(
	 * 1169,1860),get(624),get(1393),set(530,2373),get(721),get(1385),set(611,
	 * 1372),set(776,465),set(1224,2265),get(504),set(874,914),get(981),set(1006
	 * ,2584),set(1127,928),set(1157,861),get(766),set(1294,1903),get(46),set(
	 * 1417,327),set(928,204),set(1270,2146),get(1182),set(1330,440),get(846),
	 * set(1378,2022),get(833),set(173,2081),set(1167,1590),get(1029),set(1191,
	 * 1926),set(150,347),set(759,172),set(1427,1707),set(988,2645),set(753,2328
	 * ),set(1365,1709),set(229,2822),get(695),get(68),set(1132,2395),get(66),
	 * get(1117),get(7),get(1261),set(1113,2111),get(856),set(63,2630),set(1255,
	 * 654),get(109),get(923),get(685),set(1116,579),set(669,1050),set(1127,259)
	 * ,set(44,1976),get(812),set(281,2457),set(1355,2378),get(353),get(706),get
	 * (595),get(411),get(33),get(86),set(1429,1043),get(542),set(1228,309),set(
	 * 351,2368),get(890),set(224,252),get(716),set(401,789),set(986,1682),set(
	 * 886,1340),get(530),set(918,670),set(213,2330),set(255,1938),get(554),set(
	 * 1094,2910),set(752,1613),set(1330,1561),set(116,2628),get(1300),get(868),
	 * set(555,1534),set(1092,1922),get(1297),set(1168,1523),set(638,1537),set(
	 * 783,989),set(1389,728),set(459,212),set(925,359),set(382,2351),set(952,
	 * 442),get(318),set(1013,2552),get(1023),set(786,560),get(934),set(753,1787
	 * ),get(897),get(250),set(298,3087),set(153,3268),set(532,2548),set(877,316
	 * ),get(1414),get(1099),set(895,777),get(359),get(349),set(858,1450),set(
	 * 1067,445),set(380,2461),get(204),get(839),set(190,1008),get(1072),set(557
	 * ,2219),get(536),get(713),set(1202,2203),get(189),set(821,154),get(717),
	 * get(920),set(1256,2050),get(1321),set(180,854),set(467,1187),get(446),get
	 * (1426),get(1174),set(1391,2893),set(1362,2067),get(719),set(1046,2159),
	 * set(260,2418),set(8,168),set(1368,2266),set(926,1605),set(1230,1307),set(
	 * 157,2859),set(1200,312),get(347),get(454),set(558,2035),set(670,1425),set
	 * (1138,1480),set(219,560),set(462,287),get(1281),set(1089,1213),set(35,
	 * 2385),set(794,610),get(1069),get(1141),set(79,743),get(527),get(340),set(
	 * 1253,195),set(354,2075),set(796,242),set(996,3005),set(1265,1530),set(16,
	 * 1673),set(1179,44),set(1161,2343),set(723,585),get(1409),get(1080),set(
	 * 571,1461),set(1105,2523),get(1250),set(507,2473),get(393),set(645,1319),
	 * get(1039),get(337),set(1348,1183),get(1236),get(916),set(323,1048),get(
	 * 1267),set(1123,517),get(888),get(506),get(873),set(1131,2819),get(778),
	 * set(667,1429),get(635),set(158,565),get(182),get(341),get(1037),get(1337)
	 * ,set(1363,27),set(706,299),set(397,2511),get(75),get(632),get(607),set(
	 * 1014,2529),get(871),get(990),get(783),set(283,2101),set(336,559),get(449)
	 * ,set(525,87),get(740),get(622),get(780),set(911,1194),get(1266),set(711,
	 * 2609),get(516),get(1109),get(171),get(507),set(411,1336),get(885),get(
	 * 1367),set(45,2714),set(203,1369),set(852,1554),set(556,2701),set(1036,
	 * 2356),get(255),get(11),get(212),get(894),get(40),set(346,2051),set(376,
	 * 2963),get(1137),get(714),get(9),set(1314,875),set(443,2513),get(606),set(
	 * 563,496),set(933,303),get(28),set(1425,2838),set(385,55),set(1204,3190),
	 * set(927,115),set(1037,2050),set(368,3118),set(304,3185),set(1299,796),get
	 * (789),get(992),set(200,610),set(497,2907),set(1058,2930),set(255,2010),
	 * get(1409),get(939),set(737,376),get(851),set(1154,3132),set(1035,1578),
	 * get(276),set(1010,808),get(273),get(220),set(57,1411),set(955,2655),get(
	 * 653),set(239,1086),get(1325),get(40),set(10,2898),set(577,2480),set(1053,
	 * 623),set(1235,2163),set(1077,335),set(112,1661),set(319,963),set(1018,917
	 * ),set(72,1912),get(477),get(107),get(122),get(325),get(321),get(923),set(
	 * 894,3012),set(819,2374),set(665,2183),set(15,557),set(716,2376),set(361,
	 * 652),set(1050,566),set(51,61),set(86,736),get(193),get(582),set(437,1669)
	 * ,set(562,2611),set(1250,2191),set(850,807),get(27),set(994,2579),set(228,
	 * 1947),get(258),set(1085,1095),set(449,523),set(1061,55),set(74,45),set(8,
	 * 911),get(310),set(438,2957),set(623,2554),set(1394,3096),set(944,1483),
	 * set(503,64),get(1222),get(1378),set(49,2680),get(477),set(1203,1265),set(
	 * 636,1866),set(108,2355),get(782),get(100),get(1425),set(611,406),set(601,
	 * 341),set(221,961),set(544,1080),get(1202),set(652,2378),get(302),get(1368
	 * ),set(501,1425),set(1026,3105),set(1148,3153),set(85,226),set(214,2809),
	 * set(194,1270),get(199),set(704,1843),get(1298),get(1033),get(585),set(658
	 * ,3284),get(67),set(281,855),set(184,2231),get(857),get(1418),set(1165,771
	 * ),get(273),get(1206),get(1198),set(383,1210),get(209),set(927,2952),set(
	 * 1107,1957),get(515),get(1261),set(118,759),set(1062,1593),set(814,1377),
	 * set(61,1882),set(613,968),set(1367,2781),get(1268),get(20),set(1174,1389)
	 * ,set(676,3248),set(292,636),set(694,1642),set(1269,2317),get(449),set(103
	 * ,569),set(1263,623),get(1070),get(549),set(993,408),get(315),set(1225,
	 * 1907),get(1357),set(458,830),get(1390),get(124),get(750),get(256),get(715
	 * ),set(892,2905),set(506,689),set(1356,1322),set(674,1118),set(447,2133),
	 * get(1297),get(124),set(607,884),set(1347,1803),set(470,1457),get(1098),
	 * set(807,2504),set(1084,2557),get(693),set(619,2897),get(341),set(803,2505
	 * ),get(794),set(107,2465),set(157,2947),set(1342,698),set(487,1847),set(
	 * 626,1492),set(679,1124),get(643),set(579,2139),set(1165,3280),get(296),
	 * set(891,2033),set(107,1462),set(86,3246),set(286,653),set(1336,3012),set(
	 * 784,1615),set(418,1031),set(890,2135),set(144,822),get(841),set(1051,1108
	 * ),set(746,1504),set(600,913),get(1070),set(239,2729),set(771,989),set(254
	 * ,3212),get(1192),set(354,3114),set(97,171),set(652,2347),set(1139,1174),
	 * set(1358,1711),get(136),get(382),get(1057),set(413,3144),get(1175),set(
	 * 207,2303),get(929),get(488),get(1408),get(614),get(1050),set(686,2819),
	 * get(914),set(134,206),set(84,459),get(843),get(1014),set(1219,1956),set(
	 * 1101,1222),get(403),set(1378,1126),set(631,3208),set(970,3229),get(440),
	 * set(1023,2997),set(48,1756),get(594),set(871,1391),get(768),set(301,841),
	 * set(377,2507),set(565,718),set(444,3054),set(1292,1509),set(1238,3229),
	 * set(1400,994),get(709),set(314,3159),set(210,1381),set(1251,963),get(928)
	 * ,get(1324),get(290),set(1228,2950),get(719),set(240,2173),set(29,2145),
	 * set(670,81),get(1055),get(468),get(483),get(1271),set(258,929),set(623,
	 * 2292),set(1249,1808),get(243),get(1384),get(776),get(485),get(597),get(
	 * 881),set(670,1663),get(256),set(1318,1870),set(1088,1901),get(493),set(
	 * 659,613),set(687,882),set(546,864),set(518,1106),get(1148),set(460,1927),
	 * get(1182),get(1139),get(460),get(917),set(1155,335),get(427),set(266,1317
	 * ),set(187,190),set(1149,2295),set(1270,687),get(363),set(1294,1528),get(
	 * 498),get(504),set(1342,503),set(203,619),set(422,640),get(1279),set(841,
	 * 2972),get(876),set(897,2526),get(551),get(1208),get(1140),get(1257),get(
	 * 1370),get(1305),get(819),set(1010,3301),set(332,1975),set(837,690),set(
	 * 1021,1190),set(609,428),get(771),set(1363,1627),get(296),get(1001),set(16
	 * ,1527),set(1417,1218),set(1292,1371),get(1076),set(557,2246),set(948,1439
	 * ),set(770,1717),set(244,3107),set(1168,3182),get(638),get(855),get(217),
	 * get(1334),set(1165,1575),get(236),set(240,27),set(759,738),set(1380,2207)
	 * ,set(457,1898),get(613),get(898),set(764,233),set(46,1936),set(69,1831),
	 * get(857),get(926),get(481),get(1352),set(1303,1771),get(921),set(874,486)
	 * ,set(1041,3056),set(67,2034),get(1387),get(129),get(518),get(980),get(443
	 * ),set(472,1468),get(1111),get(1337),get(649),set(335,2460),get(404),set(
	 * 556,2232),get(1151),get(588),set(1328,78),get(1130),set(188,2739),set(189
	 * ,3202),set(1105,160),get(588),get(103),set(670,2477),set(778,2788),get(
	 * 478),set(132,3065),set(822,2124),get(1229),set(1385,181),get(254),get(970
	 * ),get(522),set(1412,1420),get(589),set(1113,2792),get(835),get(303),set(
	 * 1194,1477),set(134,888),set(1397,2598),get(578),set(1199,3084),get(432),
	 * get(178),set(423,428),get(87),set(1185,405),get(1428),set(755,99),set(519
	 * ,214),set(712,688),set(891,649),set(1281,1316),get(429),get(864),set(335,
	 * 223),get(882),set(975,1254),get(169),get(129),set(669,2276),set(729,361),
	 * get(860),get(1018),set(1247,3214),get(1098),set(122,1637),set(926,107),
	 * set(615,3070),get(1392),set(117,236),set(75,3008),set(688,343),get(524),
	 * set(500,942),get(24),set(1005,1384),set(554,343),get(621),get(1186),set(
	 * 581,1825),set(892,2456),get(692),set(858,2745),set(1043,1937),get(1098),
	 * set(561,376),get(1010),set(206,2294),set(14,574),set(765,15),set(650,1806
	 * ),get(908),get(332),set(393,3149),get(375),get(1305),get(1061),set(1332,
	 * 2591),set(1384,1573),get(1064),set(934,2728),get(199),set(1426,1765),set(
	 * 1188,3097),set(1330,604),set(1106,852),get(81),get(940),get(693),get(894)
	 * ,set(556,181),set(457,1291),get(89),get(227),get(1116),set(619,1691),set(
	 * 429,1795),get(26),set(503,853),set(365,581),get(554),set(944,2232),set(
	 * 878,1121),set(1270,419),set(912,374),set(622,237),set(519,2068),set(1001,
	 * 1811),set(623,1264),get(1309),get(1380),get(542),set(168,1098),set(307,
	 * 1336),set(769,3270),set(147,2080),set(1201,1808),set(420,53),set(384,2361
	 * ),set(1028,2306),set(942,2917),get(549),set(534,1804),get(333),get(1063),
	 * set(1335,2067),get(1402),set(1323,139),set(872,1824),get(1230),set(526,
	 * 2584),get(145),set(1253,299),set(1117,2078),set(915,3253),get(1158),set(
	 * 1369,2966),get(1127),get(31),set(586,1532),set(663,1100),get(811),set(600
	 * ,2684),get(1155),set(975,1565),get(554),set(150,2761),set(811,1079),set(
	 * 332,2339),get(1074),get(1273),get(431),set(617,830),get(325),get(602),set
	 * (1023,3136),get(894),set(263,3066),set(807,483),set(795,1888),set(1346,
	 * 2118),set(1221,589),set(154,3101),set(894,521),set(162,566),set(132,2741)
	 * ,get(1386),get(58),get(1337),set(865,373),get(243),set(808,1173),get(1272
	 * ),set(1421,1087),set(1042,2661),get(1201),set(1267,3138),set(404,1946),
	 * get(950),set(1368,6),get(324),set(1414,1014),set(1027,472),get(785),get(
	 * 610),get(1339),get(443),set(185,1439),set(1146,2051),get(1152),set(1327,
	 * 1556),set(627,1656),set(547,217),get(791),get(253),set(1396,1649),set(385
	 * ,2524),get(1015),set(1144,2706),get(363),get(872),set(696,634),get(1102),
	 * set(845,2322),get(1021),get(503),set(1293,2149),get(27),get(830),set(451,
	 * 1018),set(1245,2522),get(273),set(1061,1735),set(189,1936),set(1143,2891)
	 * ,set(865,2568),get(426),get(1408),get(1231),get(1019),set(134,2599),get(
	 * 892),get(578),set(1116,2686),set(1423,574),get(803),set(1193,1900),get(
	 * 169),get(14),get(1332),get(271),set(343,830),get(772),set(974,885),set(
	 * 855,963),get(236),get(413),set(1140,2721),get(691),get(1281),set(753,2321
	 * ),set(1296,1095),get(937),set(342,1082),get(1305),set(68,1202),set(649,
	 * 2277),get(1354),set(540,882),set(961,2149),set(175,1508),set(1309,2888),
	 * set(100,182),set(610,364),get(1130),set(424,2483),set(506,1623),set(315,
	 * 2482),get(96),set(388,64),set(446,608),set(668,2384),get(598),get(234),
	 * get(1409),set(351,136),set(529,3049),set(907,869),get(241),set(699,2753),
	 * get(964),set(321,942),set(397,659),set(1018,237),set(819,2907),get(1294),
	 * set(1067,2602),get(1294),set(94,163),set(199,999),get(172),set(1087,1263)
	 * ,get(1329),set(756,2669),set(813,1257),set(1071,3185),set(105,1974),get(
	 * 1380),get(313),set(900,2452),get(751),get(908),get(301),set(448,2248),get
	 * (455),set(640,2381),set(613,62),set(751,2724),set(1326,3250),get(729),set
	 * (175,59),get(1304),set(23,581),set(222,2121),get(766),get(130),set(963,
	 * 305),set(724,1084),set(55,1227),set(1401,2304),get(44),set(632,3089),set(
	 * 1032,2413),get(47),set(774,1457),set(1416,1301),get(239),get(404),set(744
	 * ,538),get(1037),get(1253),get(359),get(1130),set(688,1535),set(1336,1238)
	 * ,set(1282,2607),set(863,1971),set(19,380),get(1248),set(603,2572),get(129
	 * ),get(1263),set(411,2152),set(278,145),set(668,2173),get(672),set(770,
	 * 2420),set(1369,1510),set(521,2569),set(270,487),get(352),set(321,2960),
	 * set(1344,2758),get(32),get(205),set(581,2486),get(366),set(956,450),set(
	 * 478,3284),set(717,2448),get(1102),get(1065),get(1002),set(668,2829),set(
	 * 119,615),get(710),set(871,1951),get(1159),set(1410,2899),get(963),get(711
	 * ),get(199),set(422,622),get(1043),get(1033),set(55,55),get(199),set(307,
	 * 2891),set(820,2058),get(1084),set(1027,1672),get(428),set(1255,1946),set(
	 * 233,2103),get(1404),get(72),set(813,193),set(1414,3220),set(977,1349),set
	 * (366,2839),set(905,2235),set(647,411),get(37),set(125,881),set(312,1901),
	 * set(89,464),get(260),set(1157,968),set(145,256),set(933,274),get(817),get
	 * (1098),set(837,2111),set(242,2787),set(191,687),get(770),get(470),get(585
	 * ),get(440),set(1422,993),set(752,651),set(1251,1208),get(93),get(1201),
	 * get(1067),set(849,2430),get(768),get(360),set(662,2908),set(1277,1671),
	 * get(1157),get(532),set(71,3078),get(1085),set(951,1192),get(473),get(354)
	 * ,get(390),set(872,683),set(392,3002),get(121),get(689),get(314),get(1102)
	 * ,set(911,460),set(645,2692),get(256),get(636),set(1181,3170),set(1293,
	 * 1826),get(1301),set(472,854),set(306,2272),get(121),get(41),get(1393),set
	 * (1219,1850),set(582,2878),set(252,739),set(572,238),set(164,2481),get(267
	 * ),get(753),get(779),set(281,410),get(632),set(661,1210),get(1357),set(
	 * 1352,278),set(259,987),get(814),set(779,3160),set(216,3088),set(1255,1313
	 * ),set(357,956),set(968,3207),get(1171),get(206),set(635,2554),get(349),
	 * set(1058,264),set(201,957),get(692),set(556,2031),set(689,2156),set(336,
	 * 1235),get(396),set(498,2372),set(1042,916),set(278,1734),set(556,1162),
	 * set(1016,694),get(234),set(1357,1284),set(100,1776),get(1097),get(1096),
	 * get(1025),set(1342,356),set(489,3038),get(713),get(913),get(1282),set(181
	 * ,1774),get(453),set(347,336),get(1103),set(1414,802),set(1126,450),set(
	 * 1345,2605),get(952),get(361),set(326,1410),get(115),set(549,2472),get(822
	 * ),get(1379),set(1095,860),set(140,552),set(651,3170),get(768),set(461,215
	 * ),set(436,1078),set(1089,2618),set(1356,91),set(241,388),set(315,1231),
	 * set(49,1878),get(494),get(903),set(906,1128),get(1278),get(1311),set(806,
	 * 485),get(1056),set(1058,1393),set(805,2103),set(702,207),set(460,973),get
	 * (106),set(1256,2482),get(112),set(802,3039),get(236),set(585,2715),get(
	 * 858),get(101),get(403),get(1301),get(1014),get(612),get(374),set(615,1618
	 * ),set(1017,2513),set(1114,1027),set(23,2518),set(201,2537),set(959,787),
	 * set(1238,2693),get(170),get(888),set(1143,1458),get(202),set(727,1375),
	 * get(93),get(775),set(1122,348),set(30,2898),set(441,1620),set(502,3112),
	 * get(162),set(263,738),get(1271),get(183),set(1275,3288),get(3),set(897,
	 * 3236),set(68,2682),get(84),set(71,2692),get(971),set(654,1792),set(1243,
	 * 2444),get(320),set(1055,833),set(202,242),set(96,2478),get(813),get(238),
	 * set(284,391),get(1394),get(360),set(1247,2656),set(660,1949),set(1058,
	 * 3070),get(1397),set(1319,3118),get(513),set(30,2230),get(574),get(156),
	 * set(1070,1253),set(989,719),set(20,2981),set(76,299),set(1045,2527),get(
	 * 167),set(309,915),set(160,2916),get(1135),get(1248),set(327,412),set(757,
	 * 2509),get(612),set(238,1340),set(795,1054),get(158),get(572),set(166,2943
	 * ),get(667),get(50),set(1331,1218),get(1226),set(842,2851),set(165,975),
	 * set(1309,1463),get(1198),set(989,1537),get(772),set(419,1110),set(1155,
	 * 416),set(831,3200),set(1128,1652),get(867),get(98),set(45,421),set(122,
	 * 3272),set(763,1269),set(46,1405),get(61),get(1073),set(958,17),get(299),
	 * set(499,151),set(1352,1388),set(772,799),get(464),set(895,2069),set(149,
	 * 3056),set(658,990),set(1399,668),set(1202,3016),set(572,1552),get(768),
	 * set(492,1004),set(1218,1153),set(984,554),get(1431),set(513,966),set(143,
	 * 487),set(1037,105),get(1251),set(661,1731),get(1417),set(806,1339),set(16
	 * ,2264),set(30,2709),get(40),get(1262),get(1002),get(46),set(1124,1213),
	 * get(949),get(96),get(907),get(262),set(521,1504),set(1406,2978),set(774,
	 * 1073),get(25),get(713),get(276),set(359,938),get(866),set(1228,390),get(
	 * 294),set(1250,919),get(1193),get(1201),set(395,3068),get(33),get(174),set
	 * (1132,1531),get(1406),get(569),set(1182,3184),set(341,1207),get(974),get(
	 * 47),set(951,1257),set(322,2939),set(1122,2914),get(957),set(203,2823),set
	 * (616,568),get(94),get(347),set(1243,2443),get(30),get(451),get(686),set(
	 * 1241,1159),set(483,397),set(949,2542),set(186,2523),set(748,3146),get(101
	 * ),get(718),set(739,1179),get(747),get(1013),get(210),set(937,2658),get(
	 * 214),get(1257),set(377,3014),set(1018,1080),set(944,2726),get(1137),get(
	 * 777),get(316),set(758,3144),set(421,3161),set(821,1588),set(174,343),set(
	 * 6,1528),set(1174,1308),set(899,27),get(1345),set(132,137),get(8),get(982)
	 * ,get(469),get(516),get(663),set(952,3113),set(1356,482),set(253,2012),set
	 * (89,1548),get(89),set(33,3141),get(1053),get(1378),set(1016,858),get(551)
	 * ,get(137),set(70,1419),set(134,1322),get(349),get(1257),get(162),get(743)
	 * ,set(192,2702),set(1268,2819),get(1369),get(599),set(485,100),get(1218),
	 * get(1206),get(1154),get(92),get(4),get(488),set(708,2008),set(757,2196),
	 * set(590,1327),get(1040),get(790),get(406),get(563),set(1115,1185),set(689
	 * ,1374),get(727),get(931),get(338),get(1274),get(913),set(1355,1661),get(
	 * 1365),get(1341),set(871,343),set(138,2666),get(145),get(282),set(1416,
	 * 1685),set(875,1040),set(418,2099),set(838,2512),set(1057,886),set(636,
	 * 1997),get(1274),set(1396,1671),set(1068,3013),set(692,3248),get(558),get(
	 * 77),get(157),get(735),get(655),set(181,1351),set(1399,343),set(613,3108),
	 * set(263,3128),set(699,527),set(507,50),get(1397),get(844),set(33,364),set
	 * (995,3028),get(1214),set(348,2353),get(333),set(119,485),set(1204,2699),
	 * get(740),set(720,1434),set(1364,2601),set(1417,1621),set(722,1921),get(
	 * 223),set(1074,2864),get(1240),set(675,321),get(568),set(1048,2053),set(
	 * 1413,1841),set(831,1264),get(531),set(1027,2353),get(320),get(1194),set(
	 * 403,1588),get(1406),set(1343,3167),get(340),get(152),get(214),get(414),
	 * get(1187),set(1016,981),get(930),set(951,1557),set(1217,23),set(552,3186)
	 * ,get(1417),set(549,987),set(1037,492),get(12),get(807),get(1217),set(1261
	 * ,1409),get(33),get(299),get(541),set(88,1748),set(477,3188),get(334),set(
	 * 554,1651),set(1274,1094),set(227,951),set(440,1826),set(1208,1954),get(
	 * 617),get(455),set(1403,1866),get(132),get(620),get(118),set(421,2322),set
	 * (261,2493),set(798,1004),get(737),set(220,1589),get(946),set(3,1940),set(
	 * 375,1592),set(337,2850),set(382,1527),set(415,707),set(427,350),set(1382,
	 * 704),set(749,2394),set(610,2218),get(687),get(455),set(1159,1091),get(570
	 * ),set(852,754),set(604,1103),set(1096,2401),set(887,2050),set(1176,496),
	 * set(1323,1251),get(282),get(971),get(875),set(51,59),set(1129,196),get(
	 * 1039),get(866),get(902),set(872,3175),set(454,3016),get(86),get(655),set(
	 * 553,1988),set(1117,3224),set(546,2614),get(1179),set(1121,2990),set(1002,
	 * 1363),get(334),set(1407,1630),set(1106,2303),set(391,1945),set(5,986),get
	 * (894),get(413),set(986,2801),set(1178,3157),get(156),set(1376,2447),set(
	 * 1377,2600),get(168),set(1329,2401),get(1258),get(145),get(319),set(561,
	 * 531),get(1387),get(867),get(159),get(732),get(1343),set(367,1962),set(79,
	 * 2012),get(132),get(992),set(273,1291),get(314),get(1117),set(285,2563),
	 * get(527),set(1320,288),set(1298,594),set(249,958),set(317,301),set(943,
	 * 2701),get(1224),get(1232),get(822),set(879,774),get(803),set(1146,2526),
	 * set(1026,3047),get(619),set(576,1752),set(1250,3204),set(1192,1919),get(
	 * 570),set(300,173),set(96,2615),get(525),set(238,3213),set(567,167),set(
	 * 149,3229),get(1388),get(17),set(426,611),get(1112),get(548),set(319,336),
	 * get(839),get(1204),get(1212),set(260,1858),set(1337,191),set(725,1376),
	 * set(305,1282),get(1108),get(557),set(659,358),set(1240,2928),set(443,1375
	 * ),set(1092,2322),set(1317,818),set(282,60),get(1124),set(212,162),get(873
	 * ),get(1008),set(1106,1370),get(602),set(930,871),get(1191),set(526,3000),
	 * get(1223),get(881),get(361),get(678),get(953),get(1368),get(843),set(804,
	 * 1778),set(847,1693),set(170,3024),set(1064,2565),set(751,2324),set(561,
	 * 618),set(1158,30),get(202),set(68,2785),set(423,749),get(1294),set(66,143
	 * ),set(1166,2354),get(570),get(1061),set(273,2541),set(205,2513),set(454,
	 * 2531),get(421),set(940,1026),set(509,581),set(962,355),get(317),get(972),
	 * set(202,455),get(947),set(308,3161),get(99),get(257),get(1158),set(1033,
	 * 2519),set(1113,489),set(795,247),get(1364),set(21,761),set(59,3207),set(
	 * 107,799),set(375,1322),set(841,1691),set(1322,2063),set(684,2032),get(985
	 * ),set(1229,1056),set(520,2354),get(1142),get(307),get(1260),set(1055,2856
	 * ),get(1357),get(122),set(473,2815),get(772),set(61,1877),get(1270),get(
	 * 990),get(218),get(916),set(734,2153),get(548),get(533),get(959),set(908,
	 * 918),get(1175),set(686,129),get(810),set(447,2487),get(194),get(849),set(
	 * 1022,2304),set(590,1506),get(771),set(1109,3182),set(190,1434),set(697,
	 * 2955),set(1048,2686),set(84,3039),set(1240,3028),get(620),set(376,1440),
	 * set(688,1120),set(900,1463),set(31,1661),set(887,2300),set(603,1757),set(
	 * 714,1331),set(564,2870),set(1084,393),get(170),get(927),set(639,1714),set
	 * (1365,1428),get(850),set(1374,905),set(467,1303),set(696,1421),set(155,21
	 * ),get(133),set(1267,1272),set(1008,1300),get(530),get(72),set(344,2904),
	 * set(267,2577),get(10),set(544,1302),set(1113,2692),set(842,1252),get(1353
	 * ),set(581,253),get(576),set(537,2771),get(771),set(162,2111),set(40,2570)
	 * ,set(1306,1245),get(209),get(1345),set(581,2674),set(471,3105),set(483,
	 * 439),set(994,2629),set(895,416),get(765),get(931),set(95,691),set(31,2620
	 * ),set(1362,250),get(1301),set(255,249),set(1121,1444),get(986),get(897),
	 * set(37,1087),get(102),get(322),set(875,3143),set(893,266),get(910),set(
	 * 1133,1874),set(101,1117),set(58,2998),get(363),get(197),get(602),get(845)
	 * ,get(909),set(1335,1345),set(655,1287),set(1056,375),set(657,3195),get(
	 * 473),get(524),get(917),set(358,1587),set(793,1422),get(510),get(265),set(
	 * 1287,2631),set(470,944),get(272),get(937),get(1167),set(365,298),get(116)
	 * ,get(225),set(804,230),set(39,768),get(1159),get(282),get(578),get(131),
	 * set(243,418),set(752,438),set(973,2373),set(1131,29),set(1188,3246),get(
	 * 1192),get(1046),get(1036),get(315),get(1138),get(981),get(78),set(726,
	 * 1658),get(122),set(262,2220),get(791),set(497,1559),get(542),get(1414),
	 * set(723,472),get(794),set(379,2686),set(356,2832),get(696),get(1186),get(
	 * 707),get(895),get(47),set(1233,46),get(743),get(503),set(1123,1947),set(
	 * 126,2468),set(1068,434),get(88),get(825),set(1075,1868),get(171),get(794)
	 * ,get(515),set(691,2970),get(129),set(621,1989),get(754),get(1309),get(492
	 * ),set(99,1739),set(1241,3181),set(35,973),get(943),get(1382),get(698),get
	 * (579),get(1215),set(808,409),get(273),set(614,467),set(1011,213),set(570,
	 * 916),set(1335,2344),get(591),set(227,1911),set(708,3264),get(846),set(774
	 * ,115),set(806,1342),set(1273,2734),get(920),set(286,740),get(738),get(
	 * 1281),set(1376,117),set(1049,48),set(1031,274),set(93,1465),set(1263,57),
	 * get(514),get(1057),set(844,461),get(497),set(1014,1820),set(656,1327),set
	 * (432,3153),set(404,1606),set(71,1800),get(1126),get(1243),get(949),get(
	 * 526),set(1220,46),get(661),get(338),get(1250),set(346,1317),set(1232,2828
	 * ),set(214,3100),set(512,608),set(65,232),set(98,2665),set(182,3214),set(
	 * 426,2524),set(1090,2931),get(821),set(972,323),set(121,592),get(915),get(
	 * 678),set(767,1123),get(336),set(488,548),set(1372,519),set(474,567),set(
	 * 37,578),get(519),get(572),get(419),set(867,1729),set(944,2763),get(538),
	 * get(392),set(1159,2715),get(1417),get(756),set(742,2509),get(865),set(
	 * 1264,767),get(127),set(921,492),get(1319),get(616),set(239,813),set(1392,
	 * 3283),get(54),get(1223),set(540,1240),set(727,2843),set(707,652),get(1077
	 * ),set(968,1545),get(1247),set(116,1826),get(745),set(389,3045),set(356,
	 * 661),set(613,2355),set(935,1923),set(473,768),set(774,572),get(1274),set(
	 * 44,695),set(781,959),set(919,955),set(96,1631),set(112,2459),get(740),set
	 * (67,376),get(1074),get(610),set(1393,2305),set(365,2938),get(61),get(1016
	 * ),set(967,1187),set(206,599),set(188,2814),set(306,1254),set(761,1439),
	 * set(410,3145),get(738),set(1057,1748),get(55),set(23,2328),get(108),get(
	 * 1270),set(95,536),set(637,983),get(535),get(1131),get(974),set(94,1529),
	 * set(931,3166),get(218),get(997),set(377,2161),set(987,1201),set(1098,1983
	 * ),set(804,3186),set(808,2573),set(662,1977),set(837,2425),get(188),set(
	 * 996,1121),set(131,1289),get(433),set(1430,2099),set(256,2746),get(862),
	 * set(76,2189),set(49,2133),get(1104),get(951),set(1346,165),get(356),get(
	 * 647),get(534),set(773,2916),get(837),set(1267,1419),set(631,137),get(500)
	 * ,get(412),set(3,1816),set(1242,445),set(33,3065),get(1203),set(248,2913),
	 * get(1268),get(535),get(640),get(1152),get(1057),get(530),set(215,426),set
	 * (1208,1042),get(389),set(1107,2616),set(970,1425),set(1123,1263),get(1354
	 * ),set(339,1480),get(219),set(273,67),set(204,2294),get(1378),set(52,1582)
	 * ,get(662),set(1209,745),get(965),get(673),set(15,32),get(517),set(20,2233
	 * ),get(744),set(1253,3067),set(1260,2243),set(460,3085),set(1274,1751),get
	 * (329),set(850,1916),get(441),set(865,1755),get(495),get(1372),get(1375),
	 * set(341,249),set(247,2563),set(47,1162),get(303),set(1179,3108),get(616),
	 * get(904),set(1229,750),get(621),set(992,603),get(101),get(866),set(340,
	 * 1398),get(831),set(167,2806),get(1026),get(1345),set(1422,35),get(1157),
	 * get(858),get(1005),set(805,2715),set(1285,774),set(1043,2085),get(787),
	 * get(227),get(425),get(597),set(808,1222),get(1179),get(1252),set(197,2008
	 * ),set(240,1218),set(830,1880),set(1071,2667),set(597,1452),get(1406),set(
	 * 1058,96),get(1074),get(468),set(1196,1331),set(171,2108),get(1108),get(
	 * 689),set(638,2515),set(773,1876),get(660),get(921),set(1051,3300),set(735
	 * ,2592),set(1141,1954),set(11,2463),set(394,866),set(856,3040),get(1219),
	 * get(610),set(1070,1833),set(396,2477),get(758),set(462,2556),get(464),get
	 * (338),set(1096,225),set(115,313),set(1358,1278),get(1011),get(522),get(
	 * 168),set(155,882),set(1119,935),set(1374,1367),set(750,1070),get(413),set
	 * (1404,331),get(985),get(1399),get(186),set(730,3038),set(1402,1924),get(
	 * 333),get(565),get(437),get(1174),get(266),set(957,1983),set(907,1896),set
	 * (164,2432),get(1218),get(284),get(1401),set(628,377),set(656,2506),get(
	 * 981),get(230),get(364),get(61),set(1234,2082),set(257,2136),get(108),set(
	 * 597,1321),set(1336,1635),get(357),set(265,2966),set(417,2544),set(1171,
	 * 2684),set(1357,2460),set(221,2144),get(1251),set(773,1540),set(923,1508),
	 * set(401,1592),get(322),set(901,2544),get(929),set(1084,998),set(1405,1054
	 * ),set(342,1109),set(341,2766),set(920,974),get(1374),get(1302),set(496,
	 * 2788),set(671,1846),set(284,918),set(388,2649),get(213),get(627),get(1268
	 * ),get(68),set(1243,1797),get(66),set(57,1135),get(784),get(363),get(867),
	 * get(339),set(1386,832),set(1320,1828),get(214),set(655,609),set(697,692),
	 * set(648,508),set(1062,1360),get(1168),set(623,1985),set(595,1442),set(166
	 * ,249),set(491,857),get(1421),set(73,3161),get(763),set(470,1928),set(482,
	 * 1183),get(876),set(763,2364),get(118),set(1403,232),set(218,2180),get(137
	 * ),get(1139),set(875,828),set(727,2219),get(1130),get(1266),set(808,1208),
	 * set(141,2909),get(725),get(1071),set(1245,890),get(567),get(1393),get(687
	 * ),get(1013),set(281,1253),get(1),get(67),set(1042,2732),set(232,1001),set
	 * (925,1317),get(786),set(1368,3000),get(471),set(43,1778),get(206),set(740
	 * ,1536),set(398,1680),get(1254),get(1376),get(405),set(416,2632),get(1066)
	 * ,set(318,1871),set(224,2085),set(386,802),set(1127,111),set(1330,908),set
	 * (1138,562),set(1049,188),get(164),get(739),get(1285),set(630,756),set(854
	 * ,1779),get(326),get(730),get(860),set(488,1871),get(182),get(896),set(
	 * 1171,64),get(1146),get(452),set(301,2101),set(388,2101),set(1305,2316),
	 * get(410),set(394,1923),get(1289),set(916,1080),set(1277,3096),set(740,
	 * 2979),set(620,1753),get(616),set(624,2497),set(455,3269),set(394,3297),
	 * get(1377),set(310,1208),set(310,2940),get(309),get(326),set(690,1294),get
	 * (1054),get(646),set(486,1688),set(1259,2952),set(241,1728),get(1089),get(
	 * 1029),set(724,1354),set(1319,2755),get(1281),set(597,66),set(1162,934),
	 * set(313,1334),set(840,468),set(1117,127),get(1155),set(520,1340),set(1172
	 * ,2326),get(353),get(940),get(339),set(1237,2203),set(1389,1621),set(1339,
	 * 3203),get(682),set(1036,338),get(1014),set(150,1430),set(204,1604),set(
	 * 659,2195),get(1140),get(711),set(1188,2317),get(1197),set(1157,1928),set(
	 * 1078,3291),set(28,365),set(158,3073),set(1204,2402),set(1034,3217),set(
	 * 560,3025),set(545,2088),set(383,1404),set(788,1721),set(1270,2073),set(
	 * 1427,987),set(1324,736),set(556,35),get(112),set(495,13),get(1257),get(
	 * 216),set(644,2305),set(704,1745),set(655,1416),get(1165),set(590,339),set
	 * (594,368),set(628,135),set(1253,2662),set(1198,1949),set(81,624),set(110,
	 * 2648),set(632,973),set(548,1349),set(974,428),set(1328,382),set(1233,1868
	 * ),get(200),set(463,1154),set(91,1050),set(1349,695),get(1163),get(206),
	 * set(15,681),set(1146,1137),get(476),get(861),set(1305,3291),set(698,444),
	 * get(72),set(217,265),set(687,2577),set(260,3112),get(767),get(445),set(
	 * 819,2593),set(312,633),get(193),set(1135,375),get(1175),set(884,2231),get
	 * (574),get(1119),set(28,2691),set(929,1982),set(436,651),set(865,1543),get
	 * (804),set(668,39),set(327,1861),set(1164,1388),get(388),set(1320,1899),
	 * set(821,1428),set(640,2543),get(1092),get(680),set(776,585),set(384,1140)
	 * ,get(893),get(1274),set(1070,118),set(499,959),set(746,3040),set(241,1187
	 * ),set(404,1401),get(353),set(929,509),set(304,2831),set(333,920),set(1306
	 * ,1986),set(1118,2254),get(1074),set(1367,876),set(585,1912),set(931,876),
	 * set(274,1043),set(845,387),get(52),set(631,905),set(1093,1302),set(819,
	 * 1154),set(430,975),set(1226,2642),get(486),set(669,3176),get(985),set(
	 * 1300,1112),set(1009,2691),set(920,1210),set(3,2477),set(603,1002),get(195
	 * ),get(1165),get(1),set(576,531),set(88,1743),set(370,1256),get(270),set(
	 * 891,2805),get(1084),set(1036,3045),get(135),set(1069,656),set(782,2243),
	 * set(650,2121),get(505),set(273,1718),get(300),set(1156,115),get(1127),get
	 * (206),set(1069,654),set(933,2302),set(244,2462),get(1133),set(469,113),
	 * get(1023),get(751),get(911),get(1154),get(731),set(356,379),set(804,1517)
	 * ,set(570,440),get(87),set(1096,2173),get(635),set(1416,2111),set(475,1740
	 * ),get(1355),get(409),get(714),set(589,1823),set(1166,856),set(1187,804),
	 * get(356),set(524,2251),get(3),get(668),set(787,1716),set(1381,125),get(
	 * 1227),get(939),set(841,534),set(1371,1560),set(426,3085),get(879),get(
	 * 1063),set(1156,1972),get(114),set(684,292),get(745),set(1195,1216),set(
	 * 746,2696),set(340,1067),set(722,884),get(360),set(1012,914),set(965,191),
	 * set(1058,1399),set(30,834),set(1082,1232),get(156),get(1282),set(106,2457
	 * ),set(728,2782),get(1145),get(906),get(1121),get(872),set(971,1047),set(
	 * 954,1029),get(7),set(2,2394),set(602,2498),get(271),get(1191),set(641,
	 * 1851),get(1201),set(944,2759),set(302,510),get(842),get(114),set(944,2111
	 * ),set(840,3164),set(305,1755),get(956),get(957),get(152),set(971,2865),
	 * get(487),set(1134,206),get(1399),set(1295,2107),set(471,3053),set(529,
	 * 1818),get(1033),get(1099),set(63,2954),set(979,1167),set(301,2702),set(
	 * 640,2087),set(212,2058),set(1017,775),set(451,507),set(998,32),get(1316),
	 * get(81),set(1104,2047),get(1182),get(377),set(470,2097),set(84,547),set(
	 * 254,2946),set(551,36),get(526),get(1204),get(350),get(1134),get(77),set(
	 * 391,2148),get(431),set(176,1937),get(162),set(1148,841),get(365),set(256,
	 * 925),set(681,2557),set(1112,2155),get(310),get(258),get(1242),get(1295),
	 * set(539,2534),get(1051),set(771,19),set(1090,761),set(78,2102),get(962),
	 * set(874,787),get(166),get(245),set(58,1585),get(1168),get(496),get(1401),
	 * set(1411,323),set(1061,3046),get(1427),set(43,2173),get(1203),set(1216,
	 * 510),get(1134),get(305),set(360,2227),get(1071),set(27,2338),get(1305),
	 * set(1261,2865),get(766),get(1181),set(620,2978),set(509,664),set(1278,
	 * 1711),set(670,871),set(193,2543),set(791,232),get(1138),set(723,2938),get
	 * (672),set(1223,295),get(363),set(717,371),set(280,2713),get(664),get(299)
	 * ,set(1195,2445),get(887),get(673),set(1380,2946),get(130),get(910),set(
	 * 458,878),set(294,1043),set(962,471),set(1301,2006),set(1094,3047),get(387
	 * ),get(217),set(1091,1230),set(372,2983),get(651),set(1194,708),get(1137),
	 * set(344,772),get(805),get(978),set(440,1054),get(185),set(70,2666),set(
	 * 1383,2842),set(1425,2565),set(478,606),set(831,1105),get(1286),set(958,
	 * 2701),set(668,3035),set(273,1576),set(758,1619),get(1377),get(561),set(
	 * 1038,949),set(522,1841),get(143),get(1226),set(375,795),set(1005,491),set
	 * (347,2201),set(1232,3262),get(728),set(960,3128),get(1036),set(165,425),
	 * set(140,2904),get(1312),set(548,1134),set(1100,1427),set(714,883),set(468
	 * ,759),set(328,2211),get(1425),set(1061,1899),get(1001),get(514),set(612,
	 * 1423),set(343,2741),set(1247,745),get(44),get(1317),set(438,866),get(464)
	 * ,get(722),set(24,2198),set(805,2215),set(1178,361),set(270,1821),set(1231
	 * ,485),get(168),get(1335),set(893,276),set(808,937),get(545),get(1272),set
	 * (43,2771),set(1339,684),get(795),set(794,3264),set(719,2549),get(963),get
	 * (355),set(682,2892),get(1353),set(735,3026),set(564,203),get(1095),set(
	 * 111,2767),set(636,267),set(147,2770),set(269,3297),set(952,2366),set(1231
	 * ,1738),set(575,2010),get(8),get(506),set(1377,1028),set(25,678),set(1263,
	 * 2466),get(725),set(1200,1772),set(855,1064),set(72,504),set(445,582),get(
	 * 566),set(777,1417),get(1383),set(100,2282),set(1381,850),set(1371,2481),
	 * get(660),set(1330,2426),set(230,1590),set(327,971),set(1033,720),set(146,
	 * 3270),set(78,2322),set(190,1407),set(555,1589),set(284,2122),get(161),set
	 * (446,874),set(769,1675),set(383,2821),set(824,3031),set(428,2247),set(
	 * 1284,1783),set(846,2233),get(796),set(752,25),set(23,188),set(345,2086),
	 * set(14,1589),get(179),get(1094),get(25),set(1122,2114),set(563,1601),get(
	 * 1083),get(1176),set(26,1180),get(848),get(985),get(192),set(15,792),set(
	 * 674,2677),get(990),set(147,2259),get(918),set(533,1666),get(20),set(592,
	 * 2744),get(1285),set(442,3022),set(704,1676),set(61,2670),set(1217,2313),
	 * set(652,1659),get(1387),get(1363),set(154,2259),set(1368,1320),get(507),
	 * set(1145,2157),get(1166),set(1248,1738),get(524),set(1148,2033),get(6),
	 * get(830),set(655,2993),get(850),get(1240),set(239,735),set(1194,2554),set
	 * (1020,369),set(100,1122),set(164,1893),set(1037,2411),set(1280,1356),set(
	 * 1026,1585),get(450),set(894,1276),set(233,1399),set(673,535),set(1412,
	 * 3057),set(187,916),set(297,673),set(1060,142),get(1375),get(1360),get(631
	 * ),set(1399,1212),get(1014),get(431),get(674),get(44),set(491,141),set(303
	 * ,1406),set(691,2428),get(43),get(237),get(292),set(174,3263),get(700),set
	 * (758,2255),get(37),set(1205,1322),get(1084),set(581,1446),set(1404,307),
	 * set(572,1384),get(351),set(1349,733),set(1047,3269),set(404,1029),set(
	 * 1101,738),get(623),set(154,1231),get(366),set(1041,3135),get(534),set(
	 * 1091,2551),get(579),set(709,1088),get(1121),set(163,1552),set(1308,301),
	 * set(287,3111),set(1087,1404),set(431,777),set(239,1750),set(1426,395),set
	 * (1087,1468),get(931),get(238),get(277),set(329,1771),set(514,2357),set(
	 * 833,29),get(1298),get(346),set(408,2847),get(648),set(1339,2005),get(1363
	 * ),set(518,2818),get(578),set(20,1874),get(1362),get(1063),get(632),get(
	 * 775),set(1227,1656),set(604,1566),set(977,2891),get(1105),get(696),set(46
	 * ,1594),get(719),set(638,230),set(59,2120),set(52,1080),set(1380,1246),get
	 * (50),get(171),get(1034),get(3),set(1351,560),get(847),set(604,108),set(
	 * 1124,1087),set(1269,2335),set(292,2206),set(985,699),set(1044,3217),set(
	 * 139,2123),get(1349),set(848,240),set(1038,2704),set(1048,2085),get(769),
	 * get(1179),set(1422,1368),get(135),get(955),get(630),set(548,1071),set(
	 * 1290,1256),set(313,428),set(1026,2162),set(954,1235),get(728),set(516,
	 * 2342),set(1308,1837),get(1071),get(861),get(1377),set(1426,571),set(1296,
	 * 527),set(282,1830),set(1208,251),set(279,1154),get(76),get(1128),set(743,
	 * 2108),set(235,2134),set(1189,1341),get(1392),set(1045,694),set(1082,2336)
	 * ,get(663),set(278,2519),get(428),set(452,3110),set(202,2027),set(279,1852
	 * ),set(996,2832),set(681,2647),set(1009,2858),get(626),set(1319,1317),set(
	 * 427,2865),get(839),set(25,1818),get(893),get(184),get(110),get(945),set(
	 * 405,1842),set(946,1954),get(1042),set(1104,774),get(647),set(195,3201),
	 * get(889),get(74),set(696,1605),set(919,1147),get(341),set(1067,193),set(
	 * 638,2549),get(1057),get(1019),get(620),set(364,252),get(711),set(1246,
	 * 2596),get(56),set(673,496),get(1197),set(685,2373),get(392),get(1240),set
	 * (1307,1111),get(227),get(383),get(280),get(358),set(844,2800),get(991),
	 * set(923,3170),set(996,1938),get(645),set(1333,2714),set(540,2733),get(
	 * 1314),set(165,2768),set(158,1111),set(402,2455),get(212),get(1116),set(
	 * 544,2940),get(109),set(696,2771),set(59,3038),get(613),set(1173,3176),set
	 * (1292,2512),set(284,3214),set(174,3259),set(912,876),get(459),get(132),
	 * get(366),set(1050,2235),set(86,1343),set(562,38),get(813),set(181,1293),
	 * set(103,3197),get(1426),get(461),set(577,2367),get(145),get(77),get(759),
	 * get(842),get(833),set(1172,2456),get(1235),set(1388,2519),set(1223,2939),
	 * get(1025),set(342,323),set(1280,1818),set(745,2010),get(1111),get(706),
	 * set(1088,1369),get(4),get(48),set(1307,137),get(768),get(1047),get(1092),
	 * get(593),get(1377),get(566),set(260,1776),set(1206,224),set(1399,952),set
	 * (901,2871),set(812,2395),set(495,875),get(565),get(308),set(1360,2792),
	 * set(891,2450),get(1272),get(890),set(1355,58),set(261,1420),set(42,2220),
	 * set(1067,1465),set(560,1377),get(383),set(825,2167),set(1413,3185),set(
	 * 288,637),set(507,3146),set(403,1473),set(975,1799),set(505,774),get(686),
	 * set(1209,2067),set(643,624),set(759,1743),get(123),set(124,550),set(253,
	 * 1455),get(246),get(209),set(91,68),set(913,1681),set(878,3248),get(671),
	 * get(1416),get(184),get(1320),get(1328),set(23,1424),set(1286,824),get(906
	 * ),set(549,1372),set(1123,2488),get(215),set(288,163),get(1228),set(275,
	 * 1278),get(1043),get(1021),set(1195,1662),set(782,317),set(179,2327),get(
	 * 108),set(1149,509),set(1093,281),set(483,1141),get(270),set(940,2428),get
	 * (814),set(1409,233),set(209,640),get(450),set(633,3063),set(1373,1265),
	 * get(48),get(162),get(255),get(359),set(619,1899),set(396,789),get(562),
	 * get(409),set(412,831),get(1360),get(1074),set(151,2927),get(1259),set(819
	 * ,2194),set(1364,1829),set(211,1921),get(513),get(1351),get(1046),get(1100
	 * ),get(417),set(743,785),get(1063),get(1215),get(1213),set(1283,756),set(
	 * 1115,1956),set(600,3013),get(506),get(790),set(1332,3148),set(840,1769),
	 * set(899,3227),set(176,1146),get(514),set(1371,1342),get(710),get(686),set
	 * (1108,2778),set(336,2779),get(1125),set(603,678),set(559,1122),get(565),
	 * get(66),get(823),set(504,1366),get(1384),set(851,3275),set(1245,502),get(
	 * 580),set(608,2734),get(531),set(886,2432),get(1083),set(60,2990),set(227,
	 * 1095),set(468,444),set(128,328),get(205),get(611),set(35,2629),set(340,
	 * 696),set(543,338),set(170,2349),set(543,2678),set(747,2587),set(634,2410)
	 * ,get(447),get(1384),set(304,1709),get(1124),get(529),set(1223,1730),set(
	 * 880,3050),get(672),set(635,3167),set(494,1106),get(516),set(469,725),set(
	 * 335,440),get(660),set(544,102),get(646),set(1266,148),get(908),set(387,
	 * 3201),get(687),get(871),set(1118,307),set(195,2415),get(952),get(896),get
	 * (310),get(819),set(1247,1119),set(519,185),get(1287),get(1101),get(1023),
	 * get(335),get(1276),get(1117),set(946,2495),get(1358),set(865,3118),get(
	 * 143),get(494),set(855,1670),set(1088,2504),set(626,699),get(344),set(351,
	 * 761),set(609,2654),get(708),get(643),get(333),set(473,1216),set(948,2435)
	 * ,set(1126,1868),set(451,2734),set(587,691),get(1107),set(1123,2062),set(
	 * 483,623),get(1186),get(650),set(340,1843),get(1223),set(397,654),get(1065
	 * ),set(947,347),get(1328),get(637),set(1381,2418),set(333,698),set(1098,
	 * 2797),set(974,150),get(494),set(898,3125),set(755,1872),set(1045,27),get(
	 * 20),set(984,1774),get(353),get(164),set(1222,2687),get(904),get(672),set(
	 * 149,630),set(963,2471),get(329),set(1043,2284),set(1097,187),set(1061,597
	 * ),get(1313),get(784),get(451),set(1379,2797),set(701,1131),get(1199),get(
	 * 1246),set(171,1239),get(75),get(1195),get(537),set(608,1685),set(901,1898
	 * ),set(98,2402),get(130),set(945,299),set(341,2869),set(723,2304),set(1098
	 * ,1868),get(1243),set(168,713),get(750),set(1262,1359),get(1202),get(845),
	 * set(182,3066),set(1345,1439),get(735),set(318,3169),set(445,2850),set(517
	 * ,1775),set(1207,1862),set(97,2107),get(1348),get(560),get(117),get(764),
	 * set(831,418),set(111,2227),set(208,2645),set(1264,2190),get(124),set(106,
	 * 2830),set(171,282),set(768,1039),set(1413,476),set(1396,14),get(119),set(
	 * 24,637),set(441,3289),get(623),get(887),set(660,348),set(155,2835),get(
	 * 111),get(1223),set(1186,723),get(863),get(855),set(1081,2929),set(1366,
	 * 2704),set(776,850),get(855),get(855),get(1209),set(573,1976),get(165),get
	 * (401),get(259),set(9,2644),get(1059),set(190,1704),set(1023,2928),set(
	 * 1221,1579),set(341,2878),set(191,1179),set(57,2042),set(1013,403),get(933
	 * ),set(926,2892),get(494),set(371,126),get(444),get(1297),set(429,1419),
	 * get(820),set(889,1324),set(947,3258),get(810),get(831),set(327,1834),set(
	 * 1292,1517),set(1356,3303),set(1427,197),get(281),set(476,2824),get(582),
	 * get(228),get(162),set(70,200),set(1240,2464),set(1341,425),set(1353,283),
	 * set(2,326),get(971),get(294),set(424,1236),get(686),set(986,1097),set(23,
	 * 1250),get(975),set(53,2500),get(186),get(906),get(277),set(95,2769),set(
	 * 680,1311),get(1001),set(448,1616),set(56,1971),set(685,163),get(303),set(
	 * 540,2690),set(1354,670),get(688),set(110,1704),set(1026,363),set(704,91),
	 * set(724,599),get(149),get(409),get(704),get(1165),get(237),get(450),set(
	 * 1121,3156),set(47,2977),set(133,945),get(1338),get(249),set(9,189),get(
	 * 859),get(372),get(1310),get(558),set(24,1266),set(1178,393),get(867),set(
	 * 966,1781),get(721),set(148,122),set(457,1572),set(788,956),set(62,3259),
	 * set(500,2157),set(578,2382),set(562,2175),set(227,1990),set(949,758),set(
	 * 688,1769),get(1145),set(516,152),get(297),set(829,41),get(241),get(413),
	 * get(1349),set(776,3269),get(353),set(485,790),get(813),set(1285,1569),set
	 * (848,1596),set(358,772),set(174,2242),set(317,813),set(665,2494),set(113,
	 * 3266),set(298,93),set(231,213),set(1134,2483),get(659),set(901,803),get(
	 * 1412),set(982,1119),set(506,1964),set(599,947),get(195),get(594),get(921)
	 * ,get(1291),get(1378),set(28,3106),set(638,1013),set(859,3274),get(611),
	 * set(589,189),set(178,1540),get(915),get(156),get(899),set(1386,2053),get(
	 * 441),set(208,48),get(162),get(455),get(485),set(945,1480),get(1326),set(
	 * 67,926),get(798),set(328,267),set(267,1372),set(272,682),set(459,1978),
	 * get(920),get(974),set(340,2411),get(1245),set(66,309),get(1210),set(1249,
	 * 1083),set(938,2488),get(593),get(1061),get(1274),get(743),get(1285),get(
	 * 30),set(1396,191),get(86),set(743,2089),get(184),set(397,170),get(1206),
	 * set(137,2287),get(560),set(182,3152),set(1320,594),get(916),set(713,3130)
	 * ,set(347,827),set(718,2198),get(1084),get(271),get(536),set(266,3285),set
	 * (1050,377),set(529,1139),get(1227),set(32,1678),set(942,2821),set(59,2634
	 * ),set(545,596),set(141,987),get(558),get(767),get(1071),get(673),get(1187
	 * ),get(1424),get(6),get(1),get(279),set(170,2556),set(1013,2227),set(1171,
	 * 3124),get(352),get(729),get(113),set(1037,977),set(522,1758),get(1331),
	 * set(150,1744),get(36),get(549),set(734,2583),set(975,1543),set(479,1207),
	 * get(274),get(429),set(537,2070),set(1196,2580),get(90),set(870,1772),get(
	 * 711),get(639),set(987,123),set(1214,2604),get(243),set(2,2734),set(1182,
	 * 2527),set(482,438),set(64,492),get(815),get(1340),get(121),set(135,2203),
	 * set(1336,1651),get(1107),set(2,1280),set(1354,505),set(371,738),set(1047,
	 * 475),set(708,179),set(664,2923),set(1219,3145),get(992),get(426),set(1203
	 * ,3128),set(1,2796),set(338,9),set(1031,2226),set(101,904),set(1214,2202),
	 * set(999,3294),get(14),set(296,32),get(374),get(1203),get(1187),get(1358),
	 * get(331),set(912,931),get(283),set(190,127),get(1),get(511),set(1418,3040
	 * ),set(436,2362),set(747,2521),get(1041),set(1311,1498),set(525,2924),set(
	 * 1405,1722),get(691),set(925,1798),set(167,2434),set(253,2806),set(329,
	 * 1635),set(913,784),set(341,1597),get(317),get(620),get(806),set(239,1865)
	 * ,get(1194),set(137,2466),set(202,114),set(1376,1768),set(412,836),get(335
	 * ),set(403,232),set(48,2118),get(1245),set(448,592),set(569,2316),set(1173
	 * ,2),set(1279,1613),set(127,2507),set(995,541),set(602,2111),get(921),set(
	 * 102,1822),set(742,1693),set(355,503),get(319),get(951),get(385),set(331,
	 * 745),set(734,1356),get(239),set(1068,3026),get(1226),set(1000,1104),get(
	 * 317),get(31),set(902,238),set(527,2106),set(276,1041),get(1175),get(497),
	 * get(851),get(481),get(696),get(418),get(280),get(673),set(950,1318),set(
	 * 721,1678),set(330,2114),set(593,2802),set(24,1804),get(88),get(1304),set(
	 * 1006,840),set(328,2029),set(1010,2953),get(868),set(1171,2279),set(383,
	 * 1153),set(488,1849),set(304,623),set(614,2286),set(1249,150),get(268),set
	 * (1072,2244),set(202,3002),set(510,24),set(829,2184),get(170),set(341,1792
	 * ),set(334,1107),get(1099),set(146,3293),get(887),get(1048),get(197),set(
	 * 516,1233),get(852),set(3,770),get(810),set(1378,2069),set(913,2246),get(
	 * 1153),set(1192,2204),set(837,513),get(563),get(536),get(948),set(1175,
	 * 2732),set(1037,1195),set(1095,1540),get(108),get(62),set(119,1896),set(
	 * 968,2996),get(667),set(139,2474),set(173,1605),get(545),set(945,654),get(
	 * 59),get(1285),set(770,770),set(854,768),get(132),get(231),get(636),set(
	 * 1082,1106),set(1131,2927),set(643,3276),get(1182),get(304),set(81,2034),
	 * set(518,1873),set(620,195),get(858),set(237,1421),set(422,1747),set(759,
	 * 420),set(498,498),set(74,2870),get(1039),get(779),get(337),get(246),get(
	 * 534),get(1362),get(672),get(1425),get(379),set(121,3294),set(1034,573),
	 * set(1287,3092),get(112),set(1263,2082),get(362),set(910,2207),set(921,926
	 * ),get(871),set(46,2357),set(1085,3006),set(83,1319),get(548),get(1223),
	 * set(494,2275),get(667),set(597,2122),get(761),set(324,1110),get(643),get(
	 * 944),set(613,29),get(1370),set(243,809),get(98),set(184,2165),get(393),
	 * set(756,548),get(100),set(536,906),set(330,1067),set(1071,2865),get(937),
	 * set(1172,553),get(455),set(417,1130),set(1401,718),set(1202,2821),get(
	 * 1309),set(1188,1145),get(80),get(1039),get(843),get(1366),set(595,1047),
	 * set(867,889),get(1079),set(1086,1126),get(289),get(433),set(686,1920),set
	 * (935,1929),get(605),get(1188),get(615),set(70,1153),get(1355),set(964,
	 * 1962),get(653),set(1372,1312),set(317,2825),set(729,2892),get(563),get(
	 * 893),get(383),set(338,3042),set(275,990),get(712),set(502,250),set(1312,
	 * 1316),get(1337),get(39),get(590),get(1286),set(278,34),set(1396,3200),get
	 * (122),get(515),set(1275,1272),get(923),set(1075,2497),set(321,2891),set(
	 * 262,127),get(370),get(173),set(1127,1097),set(1018,842),get(437),set(615,
	 * 2880),get(1333),set(1300,1005),set(493,2668),set(1290,2933),set(149,2554)
	 * ,set(1285,767),get(8),get(1013),get(783),set(983,2696),get(547),get(1164)
	 * ,set(606,2467),get(511),set(819,676),get(414),get(70),set(243,1906),set(
	 * 684,1788),get(814),get(669),set(937,2128),set(991,2493),set(628,2301),get
	 * (1113),set(578,840),set(375,297),set(623,14),get(986),get(344),get(498),
	 * get(498),set(1009,2722),set(451,2173),set(466,477),get(471),set(753,1196)
	 * ,get(1228),set(290,454),get(1211),set(345,846),get(1329),set(400,1411),
	 * get(254),set(412,2175),set(1361,618),set(1401,2188),get(63),get(829),get(
	 * 168),set(298,1633),get(79),set(323,2827),get(43),get(612),get(644),get(
	 * 943),set(415,1244),set(1274,1799),get(615),set(139,2319),get(875),set(
	 * 1211,1678),set(105,58),set(1010,1688),set(1416,409),get(905),get(420),get
	 * (1386),get(733),get(60),set(1201,153),get(493),set(522,1081),set(651,498)
	 * ,set(612,2127),set(1309,2150),set(272,3238),get(1163),set(794,2037),get(
	 * 205),get(1319),get(492),get(1119),get(963),set(961,1983),get(152),set(317
	 * ,2517),set(65,416),set(695,2974),set(1108,1499),get(979),set(1301,2944),
	 * set(1211,1975),set(756,1804),set(736,2971),set(240,3191),get(598),set(
	 * 1263,1652),set(1279,1971),get(667),get(659),set(150,360),set(924,2584),
	 * set(1332,1083),set(916,1689),set(1280,3139),get(974),set(417,127),set(189
	 * ,39),get(490),get(536),set(1358,1911),set(200,3216),get(1204),get(225),
	 * get(103),set(1059,1593),get(1147),get(1067),set(240,2029),set(897,903),
	 * set(863,1774),set(1350,1641),set(77,2530),get(1141),set(155,231),set(1261
	 * ,2675),get(68),set(308,557),get(1290),set(298,2779),get(890),set(577,1438
	 * ),set(113,2522),set(362,2306),get(503),set(1094,1668),set(1394,1560),get(
	 * 844),get(503),set(1297,179),set(665,2484),set(467,1152),get(297),get(1351
	 * ),set(15,1839),set(936,486),get(117),set(753,1966),set(66,1146),set(1105,
	 * 1395),get(293),set(1371,2125),set(271,3027),get(903),get(526),set(657,
	 * 1115),get(150),set(272,1684),set(1204,283),get(1334),get(825),get(57),get
	 * (20),set(1356,292),get(266),get(308),set(359,1758),get(1067),set(1071,
	 * 1882),set(132,1396),set(1251,1874),set(749,1011),set(434,1727),get(428),
	 * get(420),get(1279),get(908),set(884,422),get(1120),set(427,1265),set(592,
	 * 355),set(864,3058),get(1186),set(1273,1259),set(887,938),get(1181),get(
	 * 1396),get(1224),set(441,512),set(15,258),set(1395,2231),get(799),get(151)
	 * ,set(828,2798),get(508),set(247,1505),get(1171),set(647,2687),set(14,973)
	 * ,set(401,2908),set(994,667),get(1333),set(360,1348),set(324,699),get(690)
	 * ,set(128,597),set(1019,876),get(1346),set(739,2635),set(1267,1267),set(
	 * 404,1508),get(682),get(701),set(203,1139),get(647),get(1306),set(1254,437
	 * ),get(741),set(724,1418),set(811,930),set(855,58),get(281),get(1214),set(
	 * 428,2364),get(48),get(924),get(168),get(1022),set(479,2500),set(150,2182)
	 * ,get(555),set(122,3277),set(613,1713),set(101,1961),get(721),set(146,747)
	 * ,get(1269),set(850,751),set(855,3141),set(17,2818),set(738,129),get(119),
	 * get(1366),set(420,1421),get(86),set(259,2414),set(131,3175),set(644,1299)
	 * ,get(829),set(534,1600),set(1102,1998),set(420,1037),set(104,1343),get(
	 * 291),set(357,140),get(449),get(924),set(1211,1621),set(1337,2717),get(220
	 * ),set(1044,1499),get(1224),set(991,2889),set(614,1109),set(1004,1498),set
	 * (1162,796),set(1302,1366),set(1407,3253),set(441,2547),get(152),set(133,
	 * 1507),set(1319,3014),set(1379,2043),get(885),set(842,332),set(32,763),set
	 * (1120,1850),set(902,1411),set(848,2536),set(242,2646),get(384),set(568,
	 * 1021),get(535),get(884),set(295,1720),set(104,534),set(256,3279),get(883)
	 * ,set(424,509),get(44),set(86,944),set(618,1539),get(130),set(752,1362),
	 * set(320,471),set(385,1034),set(969,378),set(1176,2589),set(1406,1643),set
	 * (572,1650),set(925,1394),get(213),set(1071,346),get(1223),set(1112,52),
	 * set(708,1517),set(682,2145),get(360),set(856,2476),set(1303,643),get(1240
	 * ),get(934),set(343,2364),set(1190,1805),set(966,1380),get(399),get(1280),
	 * get(1219),set(584,1000),get(1329),set(1383,1240),set(1200,1750),get(716),
	 * set(842,2201),set(1062,974),get(894),get(1130),set(571,193),get(720),get(
	 * 765),set(466,1167),set(1150,304),get(1368),get(530),set(490,1182),set(
	 * 1198,3082),set(1323,2335),set(1274,474),set(133,1865),set(968,1119),set(
	 * 388,2435),set(66,1238),set(808,2666),get(177),get(637),get(395),set(1426,
	 * 1315),set(74,3015),get(459),set(608,83),get(525),get(1020),get(162),get(
	 * 272),get(568),get(135),set(1016,1263),get(504),set(345,1887),set(640,521)
	 * ,get(344),set(296,157),get(726),set(450,1076),set(242,1139),get(358),set(
	 * 630,459),get(843),get(1134),set(1125,3020),get(986),get(296),get(1412),
	 * set(248,1469),set(1075,581),set(639,1271),get(1053),get(1124),set(1294,
	 * 3163),get(488),set(1318,2900),set(227,2777),set(901,899),set(1149,2558),
	 * get(51),set(1254,2949),set(1290,1917),set(292,2392),get(1404),set(1272,
	 * 2693),get(78),get(203),get(1105),get(1056),set(1111,2201),set(852,1061),
	 * get(411),get(599),set(1070,2272),get(1246),set(563,3048),get(448),get(364
	 * ),get(927),get(27),get(691),set(150,909),set(1299,781),get(1295),set(1357
	 * ,1983),set(235,286),get(460),get(367),get(160),get(1106),get(854),set(100
	 * ,3032),set(99,1150),set(722,2184),get(274),get(97),set(919,671),set(14,
	 * 3289),get(50),get(170),set(957,2228),set(1303,1393),get(1339),get(967),
	 * get(1126),get(1419),get(970),set(205,2062),set(1413,385),get(1288),get(
	 * 170),get(983),set(344,2448),set(895,2743),get(44),set(80,1257),get(680),
	 * get(8),set(113,2675),set(866,1157),get(567),get(469),get(1033),set(773,
	 * 1012),set(1157,1126),set(849,2910),set(900,2003),set(402,1031),get(613),
	 * set(338,505),get(1210),set(681,1690),set(337,125),set(1332,3115),set(485,
	 * 1937),get(1246),set(565,1072),set(1328,3057),get(210),set(1170,1871),set(
	 * 232,288),set(274,1428),set(572,143),set(151,704),get(698),set(397,3224),
	 * get(608),set(963,823),get(601),set(974,199),get(390),get(183),get(1412),
	 * get(675),set(247,1623),set(866,1921),set(653,1532),set(945,2170),get(45),
	 * set(111,1537),set(883,2699),set(728,121),set(197,296),set(847,285),set(
	 * 1221,2173),get(83),set(1292,821),get(294),set(699,1830),set(1209,3097),
	 * set(461,2438),get(912),set(43,768),get(476),get(974),set(115,573),get(
	 * 1194),get(31),set(1095,1533),set(1169,578),set(614,276),set(1298,781),set
	 * (949,2511),get(256),get(122),set(1423,356),set(392,882),get(360),set(566,
	 * 937),get(944),get(503),get(603),get(960),set(1405,2635),set(1152,186),get
	 * (1344),set(16,1486),get(540),set(308,2980),get(512),get(1275),set(4,1726)
	 * ,set(595,351),set(726,2163),get(1251),get(1405),set(1155,1012),get(27),
	 * set(548,29),get(87),set(1401,1014),set(1375,2803),set(766,211),get(44),
	 * set(1320,2312),set(390,1841),get(1166),get(1094),set(133,2510),set(110,
	 * 358),set(232,1368),get(816),get(1239),set(36,1694),get(557),set(501,369),
	 * set(199,1874),set(1076,2402),get(1072),get(1421),set(852,326),set(368,
	 * 2412),set(1402,3161),get(224),set(49,309),set(740,2580),get(34),set(856,
	 * 2798),get(326),get(265),set(884,2257),set(264,758),get(687),get(1239),set
	 * (302,586),set(895,940),get(815),set(408,1670),get(716),set(1230,599),get(
	 * 283),set(1202,2713),set(53,1621),set(153,2204),set(1429,1254),set(506,64)
	 * ,get(952),set(901,1985),get(591),set(1239,30),get(1002),get(585),set(908,
	 * 61),get(312),get(148),get(81),get(562),get(672),set(16,1566),set(1392,
	 * 1322),set(1362,1071),set(708,1188),set(33,2500),set(769,2162),set(1284,
	 * 2449),get(638),get(996),get(1342),get(756),get(429),set(1008,3251),set(
	 * 1328,1170),set(104,2952),set(320,1239),get(849),get(1009),get(768),set(
	 * 375,2056),set(509,578),set(464,129),set(1083,606),get(817),set(106,2750),
	 * set(1204,2499),set(554,2231),get(164),set(552,99),set(1109,1286),set(606,
	 * 1172),get(757),get(517),get(1264),get(316),set(1333,374),set(127,249),set
	 * (711,181),set(1017,3068),set(302,3185),set(45,456),get(757),set(1204,1827
	 * ),get(153),set(926,2535),get(462),set(819,1777),set(697,2547),get(208),
	 * set(457,1048),get(1263),get(400),get(94),set(952,2466),set(939,1773),get(
	 * 1316),get(1127),get(958),get(825),set(186,2751),get(753),set(241,2129),
	 * set(1316,2623),set(643,2434),get(76),get(1216),set(823,3126),set(1369,
	 * 2232),set(15,326),get(1373),set(800,2667),get(357),get(166),set(395,2271)
	 * ,get(1300),set(908,2327),get(905),get(34),get(213),set(815,952),set(507,
	 * 1695),get(512),get(1146),get(582),set(716,155),set(175,795),get(342),get(
	 * 1096),get(1208),get(1428),get(1268),get(533),set(609,1887),get(212),set(
	 * 924,503),set(225,2755),set(919,272),set(390,1315),set(1337,1475),set(1422
	 * ,1786),set(98,1322),get(927),set(312,2443),get(740),set(1297,344),set(347
	 * ,868),get(1425),get(216),set(309,3008),set(406,277),set(1418,785),set(66,
	 * 993),set(1260,2603),get(444),set(743,3025),get(261),get(1207),set(249,
	 * 1589),get(1045),get(756),get(117),set(784,2545),set(412,853),get(1350),
	 * set(1142,2415),set(595,1233),get(189),get(262),set(1394,2526),get(252),
	 * set(1012,306),set(664,1590),set(774,560),set(187,2317),set(1262,499),set(
	 * 419,421),set(188,817),set(142,2978),set(1407,2804),get(70),get(352),set(
	 * 688,601),set(271,2282),set(857,868),get(910),set(910,1584),get(1267),get(
	 * 1334),set(820,837),get(519),set(481,2370),set(75,15),set(572,1632),get(
	 * 1259),get(119),get(505),set(464,618),set(635,3281),get(432),get(822),get(
	 * 1139),set(367,2713),get(1029),set(303,811),set(973,2536),set(258,1103),
	 * set(701,1604),set(1308,1110),set(262,752),get(418),get(576),get(893),set(
	 * 352,701),get(1056),set(570,3132),set(1280,17),set(312,35),set(559,1006),
	 * get(547),set(1081,1440),set(841,128),set(674,332),set(1158,3020),get(514)
	 * ,set(1209,3173),set(14,3002),set(1134,2718),set(1379,2477),set(1053,2977)
	 * ,set(662,2289),get(1093),get(1019),get(375),get(242),set(317,821),set(
	 * 1125,1969),set(1392,2733),get(1393),set(854,3268),set(1238,3067),set(348,
	 * 1539),get(1363),get(357),set(85,3086),set(67,270),set(1225,504),set(216,
	 * 2743),set(599,1060),get(464),get(855),set(1267,1416),set(1227,2149),get(
	 * 431),get(637),get(251),set(1291,289),set(20,2639),set(1043,2780),set(351,
	 * 1557),set(1081,3033),get(879),get(1196),set(1085,1668),get(97),set(800,
	 * 657),set(578,2384),get(685),set(600,119),set(1146,1823),get(846),set(584,
	 * 644),set(974,1683),get(757),get(664),set(1304,2697),set(1377,1142),set(
	 * 539,1587),set(1275,2563),set(130,927),set(87,2177),set(790,1626),set(973,
	 * 2716),set(482,431),get(362),set(751,1522),set(436,1700),set(782,180),get(
	 * 112),set(691,1981),get(243),set(571,1058),set(361,91),get(229),get(383),
	 * get(383),get(64),get(744),set(1057,955),set(726,301),set(1304,701),set(
	 * 136,2490),set(683,2581),get(1249),set(154,778),get(242),set(843,288),set(
	 * 318,1781),set(507,1615),set(346,1002),set(1217,2345),get(379),set(719,
	 * 2029),get(748),set(1228,2043),set(1078,2732),get(1257),set(1277,2371),set
	 * (373,2894),set(127,3105),get(1243),set(1084,390),set(244,1394),set(1062,
	 * 1128),get(531),set(1081,1576),set(1010,1153),get(410),set(884,2865),set(
	 * 1228,388),set(144,3173),set(93,571),get(421),get(418),set(1092,3168),set(
	 * 847,425),set(1319,27),set(272,1090),set(910,1723),get(120),set(1016,2284)
	 * ,set(351,2261),get(931),set(112,568),set(255,2783),get(25),set(738,1342),
	 * get(316),set(600,1225),set(280,2152),get(543),get(104),set(958,2012),set(
	 * 394,2558),set(32,3043),get(829),set(575,724),get(14),set(883,178),set(362
	 * ,1555),get(618),get(95),get(1130),get(784),get(548),get(474),set(967,2137
	 * ),get(1131),get(934),set(1356,1547),set(994,3263),set(1102,1525),get(837)
	 * ,set(973,2014),get(778),set(629,1303),set(477,665),set(1104,1263),set(
	 * 1231,3071),get(26),get(1274),set(193,1652),get(778),set(687,2404),get(598
	 * ),get(76),set(644,2730),get(301),set(26,3054),set(498,3286),get(1121),set
	 * (474,7),get(165),set(294,93),get(359),set(477,2597),get(194),set(218,2893
	 * ),get(517),set(594,2632),get(509),set(936,3212),set(1175,2476),get(1165),
	 * set(573,3183),get(135),set(260,1487),set(850,1431),set(12,2507),set(659,
	 * 868),set(592,204),get(1054),set(690,100),set(1206,2052),get(1369),set(691
	 * ,2389),set(579,1029),get(784),set(497,472),set(818,1433),set(981,1150),
	 * set(254,1855),get(1416),get(1154),set(1263,185),get(121),set(1127,1808),
	 * set(1259,2791),get(436),set(1326,478),get(258),get(1060),set(922,2315),
	 * get(164),set(984,1658),set(895,1418),get(1150),get(1146),set(864,709),get
	 * (1271),set(211,358),set(448,2703),get(392),set(625,2149),set(728,3221),
	 * set(429,746),set(1254,2190),get(468),set(258,3043),set(675,252),set(1024,
	 * 956),get(721),set(27,534),set(1262,195),set(893,2879),get(306),get(1101),
	 * set(724,2063),get(1019),get(1060),get(452),set(513,2851),get(886),get(437
	 * ),set(362,1887),get(110),set(1405,392),set(590,996),get(1238),set(1315,
	 * 262),set(1117,1929),set(146,2119),get(971),set(337,1916),set(381,1820),
	 * get(757),get(844),get(1147),set(1192,1077),get(889),get(631),get(1004),
	 * get(550),set(437,36),get(1361),set(888,2942),set(257,1054),get(428),get(
	 * 1305),get(1214),get(842),set(1014,1079),set(1179,930),get(572),set(278,
	 * 1495),set(548,2066),get(538),get(1353),set(972,2438),get(219),set(1324,
	 * 367),set(49,549),set(1282,2229),set(82,2472),get(634),set(1090,379),set(
	 * 765,1283),get(196),get(322),get(1124),get(740),get(302),get(1123),set(96,
	 * 1805),set(694,1518),set(20,2008),get(1008),set(1427,797),get(299),set(
	 * 1132,1839),set(167,2249),set(582,1232),set(1411,141),set(16,2888),get(
	 * 1074),set(1420,2456),set(1150,479),set(634,2974),set(681,2398),set(527,50
	 * ),set(712,676),get(336),set(483,2769),set(34,1706),set(1027,837),set(169,
	 * 3075),get(176),set(580,2516),set(1368,2764),get(193),set(91,2880),get(892
	 * ),set(144,592),set(1089,2799),set(302,613),set(285,2500),get(259),set(201
	 * ,105),set(498,1716),set(947,1751),get(1219),set(157,262),get(354),get(96)
	 * ,set(924,1895),get(95),set(145,2558),set(632,401),set(1377,2142),get(211)
	 * ,set(601,1876),get(1181),set(1038,3220),set(843,1031),set(265,2581),set(
	 * 766,853),set(817,3029),set(954,816),set(47,3291),set(807,1769),get(880),
	 * set(168,2815),set(250,2554),set(114,2531),set(813,1731),get(134),set(529,
	 * 2001),get(899),get(861),get(413),set(455,157),set(663,953),set(390,3189),
	 * set(684,2817),set(1156,1503),set(484,457),get(1430),set(681,3074),get(
	 * 1263),get(123),get(682),get(11),set(961,1122),set(588,2222),get(416),get(
	 * 835),set(671,2728),set(758,1191),set(601,3018),get(1345),set(59,1116),get
	 * (564),set(37,1493),get(251),set(570,2032),set(58,3232),get(1132),get(366)
	 * ,set(232,1108),set(967,111),set(158,1474),get(124),get(721),get(440),get(
	 * 293),get(1249),set(1341,1271),get(1263),get(77),get(1049),get(1401),set(
	 * 1218,1680),set(1429,2156),get(770),set(1179,1283),get(962),set(93,2959),
	 * set(1313,3202),set(601,357),set(1379,3026),get(79),set(1140,3097),set(469
	 * ,1643),get(669),set(830,3110),get(622),set(524,3075),set(1351,1803),get(
	 * 183),get(24),get(467),set(769,2936),set(101,1025),get(846),set(917,1622),
	 * get(299),set(1199,2068),get(958),set(443,1750),get(1316),set(1232,1755),
	 * set(477,2505),get(870),get(120),set(1416,1403),set(1259,2257),get(584),
	 * set(1176,3202),set(944,165),get(197),set(907,2442),set(893,2256),set(17,
	 * 851),set(502,926),set(1380,34),set(427,2460),get(343),set(999,1235),set(
	 * 239,1676),get(55),get(402),set(286,1784),set(967,1469),set(460,76),set(
	 * 863,355),get(319),set(1048,3064),set(156,937),get(489),set(361,461),get(
	 * 314),set(316,1662),set(1212,67),set(802,2289),get(545),set(216,383),set(
	 * 158,1763),set(208,55),set(1317,1540),set(352,2396),set(801,1311),set(1384
	 * ,3092),set(963,1383),set(265,1870),set(1285,3082),get(3),set(1003,1780),
	 * set(1210,559),set(773,3250),set(640,373),get(55),set(1279,2805),set(1336,
	 * 395),get(518),get(1336),get(990),set(293,3204),get(327),set(1204,1673),
	 * get(697),get(991),get(505),set(589,1198),get(971),set(1298,1367),get(508)
	 * ,set(239,2198),set(384,736),set(1088,2052),get(1243),set(412,2590),set(
	 * 1386,382),get(943),set(1265,2500),set(1163,2971),get(950),get(336),get(
	 * 595),set(400,176),set(574,1936),get(801),get(955),get(951),get(568),get(
	 * 920),set(389,1015),set(1328,2147),get(361),set(651,1125),get(331),set(781
	 * ,1821),get(142),set(747,2726),set(507,2284),set(1099,1757),set(1358,2536)
	 * ,get(255),set(1102,1093),set(434,2611),set(1135,150),get(1311),set(230,
	 * 2971),get(1173),get(885),set(1306,1919),set(989,136),set(13,1694),set(541
	 * ,777),set(584,2799),get(829),get(435),get(673),get(1290),set(997,417),get
	 * (395),get(144),get(849),get(1317),get(57),set(1398,695),get(1198),get(968
	 * ),get(1228),set(865,3099),set(1273,777),set(1220,1141),get(598),set(121,
	 * 1793),set(1192,1316),set(31,328),set(199,138),set(1174,2836),set(1257,680
	 * ),get(420),get(738),get(472),set(431,341),set(339,2640),get(305),set(223,
	 * 2701),set(816,662),set(486,1239),set(663,1215),set(479,1419),set(491,922)
	 * ,get(1400),get(581),get(1037),get(138),set(542,2598),set(152,2368),set(
	 * 167,61),get(1084),set(1223,3108),set(987,1206),get(1089),get(1058),get(
	 * 781),get(562),get(1084),set(348,1225),get(764),set(496,1555),set(784,157)
	 * ,set(1067,3159),set(722,2459),set(564,1894),get(1010),set(181,1630),set(
	 * 1071,178),get(505),set(1095,670),get(762),get(186),set(708,36),get(353),
	 * set(1193,2999),get(1301),set(520,396),set(296,2870),get(399),set(1050,741
	 * ),set(614,2329),set(35,510),set(315,1914),set(1430,2827),set(1146,2533),
	 * set(19,2053),set(176,174),set(905,203),set(998,858),get(890),set(874,981)
	 * ,set(1109,347),get(989),get(117),get(614),set(1320,2157),set(1186,635),
	 * get(526),set(957,1989),get(996),get(574),get(648),set(333,2271),set(1089,
	 * 1598),set(594,1676),get(864),set(637,794),get(1366),get(326),set(904,3055
	 * ),set(332,2361),set(1301,692),get(786),set(1168,2392),get(339),get(132),
	 * get(743),get(296),get(684),set(401,1398),get(74),set(759,3098),get(21),
	 * get(1325),set(1277,2631),set(783,1441),set(182,2544),set(1044,311),set(
	 * 940,1625),set(898,2018),get(940),get(880),set(540,2318),get(772),get(288)
	 * ,get(40),get(1244),get(1359),set(101,2076),set(1203,1576),get(201),set(
	 * 407,1220),get(1150),get(391),get(921),get(691),set(113,2391),set(114,14),
	 * set(282,1348),set(108,2765),get(492),set(681,2249),set(1019,1923),get(565
	 * ),set(1424,1996),set(119,1745),set(932,687),get(369),set(906,2926),get(
	 * 449),set(35,3288),set(708,397),get(1088),get(77),set(370,2840),set(1258,
	 * 1330),get(1),get(1075),set(450,3147),set(839,182),set(105,354),set(306,
	 * 341),get(1061),set(520,599),get(6),get(18),set(821,579),set(902,2900),get
	 * (269),get(1165),get(187),get(1405),set(1234,1466),get(1221),set(89,71),
	 * get(561),set(1295,895),set(565,1291),set(1196,2527),get(128),get(236),set
	 * (336,3248),get(175),set(1160,601),set(799,195),set(541,1566),set(591,1358
	 * ),set(892,1878),get(1362),get(294),get(418),set(297,2792),get(744),set(
	 * 565,1469),set(161,817),set(750,1922),set(594,2245),set(417,1948),set(758,
	 * 2264),set(1066,2419),set(427,322),set(615,1481),set(325,1494),get(532),
	 * set(1069,1968),set(621,156),set(107,674),set(1127,1457),get(25),set(699,
	 * 1706),set(1331,1744),set(434,1569),get(329),set(47,2944),set(1089,50),set
	 * (913,2387),set(1353,876),get(1265),set(1135,556),set(663,1055),set(980,
	 * 2569),set(917,2630),set(596,2790),set(561,412),get(181),set(1349,514),set
	 * (1212,1062),set(1356,3102),set(1342,1570),get(426),set(81,910),set(1049,
	 * 3022),set(1307,1340),set(165,2966),set(1259,169),set(884,675),set(374,
	 * 1215),get(1407),set(666,2598),get(1175),set(991,2076),set(520,26),get(284
	 * ),get(296),set(964,955),get(453),set(516,170),set(946,1757),set(714,2688)
	 * ,set(598,1289),get(1286),set(1018,29),set(473,804),get(775),set(727,2026)
	 * ,get(395),set(545,545),set(21,470),set(633,700),set(396,2144),set(687,
	 * 3054),set(1225,3004),set(731,2208),set(1326,2396),get(776),get(271),set(
	 * 218,503),set(1286,2306),get(1013),get(267),get(1219),get(1267),get(1324),
	 * set(1064,2954),get(876),set(1144,1697),set(953,2964),get(1159),get(352),
	 * set(54,2713),get(902),get(799),set(276,3040),set(425,2830),get(779),set(
	 * 485,776),set(452,2445),get(613),set(1022,1954),get(730),get(694),get(1127
	 * ),get(852),get(190),set(601,224),set(600,1110),get(993),get(1291),get(891
	 * ),get(764),set(688,227),set(739,3303),set(1075,19),set(697,2369),set(275,
	 * 1685),get(748),get(1145),get(824),get(1429),get(1072),set(533,1564),get(
	 * 97),get(149),get(738),get(267),set(950,86),set(493,2802),set(959,2468),
	 * get(175),set(217,2776),get(1079),get(1260),set(416,1030),get(6),set(831,
	 * 577),get(948),set(1156,1194),get(1309),get(153),set(1082,2709),get(125),
	 * set(415,2375),get(922),set(391,874),set(1194,437),get(537),get(679),get(
	 * 1364),get(1071),get(12),get(1142),set(684,2743),set(1279,1839),set(1113,
	 * 1161),set(1309,1407),set(346,211),get(823),get(523),get(1426),set(1248,
	 * 1046),set(872,209),set(150,854),set(1098,2601),get(1283),set(777,850),set
	 * (603,891),set(536,1072),get(255),get(1223),get(591),set(1380,616),set(
	 * 1237,2837),get(75),set(407,2300),set(892,2140),get(1367),set(730,1742),
	 * get(839),set(864,2876),set(390,691),set(1104,1100),get(135),set(433,3007)
	 * ,get(1123),get(271),set(286,1481),set(115,2447),get(629),set(860,211),get
	 * (791),set(134,3122),set(1327,176),set(67,760),set(12,654),set(1083,441),
	 * set(1358,1240),set(1158,861),set(618,1885),set(1367,487),set(175,106),set
	 * (39,1035),get(923),set(132,209),set(673,209),set(937,2956),set(900,1603),
	 * get(1002),get(151),set(625,1304),get(672),set(244,202),get(1144),set(430,
	 * 2989),get(1064),set(907,3012),get(270),set(929,1214),get(978),get(954),
	 * get(688),get(999),set(217,1887),set(805,1032),get(688),set(993,2763),set(
	 * 444,220),set(1221,1384),get(1001),set(98,1002),set(1378,1269),set(439,
	 * 2878),set(1116,2208),get(463),get(1147),set(38,1368),get(543),get(18),get
	 * (311),set(1161,2874),set(1294,3045),set(489,176),get(1252),get(1377),get(
	 * 1360),get(1192),set(595,407),get(1289),get(927),set(985,822),set(1256,
	 * 2158),get(1234),set(218,142),get(462),get(345),set(757,2736),set(1153,
	 * 2120),set(157,1564),get(1046),set(1277,2927),set(1086,2955),set(337,2389)
	 * ,set(619,2265),set(665,1026),get(496),set(30,2371),set(461,1400),get(1003
	 * ),get(812),get(1256),set(290,2012),set(462,3110),set(1355,1649),set(993,
	 * 1586),get(5),get(103),set(1418,360),set(83,2230),get(125),set(1379,2924),
	 * set(964,2096),set(755,2586),get(58),set(129,1461),set(835,3118),get(1303)
	 * ,set(813,235),get(1310),get(367),set(287,2402),get(844),get(794),set(1160
	 * ,2209),set(771,2205),set(1273,1681),set(203,554),set(504,182),set(525,
	 * 2294),set(257,2743),get(896),get(272),get(1004),get(417),set(1405,527),
	 * get(884),get(821),set(772,827),set(167,422),get(614),set(428,2376),set(
	 * 512,2504),get(1014),set(1046,3228),set(856,1281),set(1135,809),set(1074,
	 * 1388),set(812,1640),set(24,3197),set(105,2475),get(600),set(5,925),get(
	 * 1042),get(575),get(260),get(748),set(523,1320),get(1346),get(140),set(283
	 * ,3166),set(858,3222),get(1125),set(324,3274),set(1288,939),get(1135),get(
	 * 296),set(1187,637),set(1013,2160),set(6,684),set(958,2321),set(262,1225),
	 * set(902,1257),get(1425),get(552),set(1100,1694),set(379,395),get(521),get
	 * (754),get(14),set(1252,276),set(85,3062),set(846,2515),get(571),get(419),
	 * get(1147),set(1073,2078),set(1053,738),set(1304,2983),set(202,33),set(530
	 * ,1705),set(1366,1454),set(42,932),get(982),set(781,695),set(818,1817),get
	 * (293),get(510),set(566,203),set(1066,750),get(273),get(523),get(1289),set
	 * (940,385),set(793,2359),get(628),set(279,2673),get(753),get(12),set(1079,
	 * 1245),set(757,2221),set(646,1399),get(735),set(838,1488),set(272,107),get
	 * (723),get(844),set(816,797),get(84),set(1342,1076),set(642,712),get(1018)
	 * ,set(890,3125),set(763,1415),set(539,390),get(249),set(531,1962),get(808)
	 * ,set(1093,2626),get(139),set(225,3012),get(546),get(406),get(473),get(369
	 * ),set(1391,1506),set(329,559),set(400,2141),get(1318),set(1144,1128),set(
	 * 240,7),get(39),set(1320,236),get(542),set(327,2417),set(93,2223),set(1155
	 * ,464),set(632,1924),get(751),get(1038),get(1280),set(1102,1688),set(1083,
	 * 1427),set(456,1715),set(1048,621),set(806,2163),set(1392,852),set(1293,
	 * 433),get(1205),get(1237),get(233),get(817),get(779),get(406),get(1393),
	 * set(799,2980),get(960),get(135),set(1379,2763),set(1040,3188),set(245,
	 * 2966),set(305,1492),get(354),set(12,1662),get(930),get(1105),get(998),get
	 * (379),set(39,686),get(1372),get(687),get(1423),set(1332,1756),get(1347),
	 * set(1191,1716),set(1103,271),set(169,2001),set(1326,2125),set(700,2385),
	 * get(861),set(1105,2214),set(718,1351),set(187,2198),set(287,2929),get(123
	 * ),get(853),get(501),get(238),get(1226),get(987),get(569),get(25),get(149)
	 * ,get(314),get(81),set(1029,1973),get(846),get(209),set(1230,1252),get(81)
	 * ,set(249,2480),get(640),get(1030),get(736),get(241),set(1180,1012),set(
	 * 1032,2924),set(556,2934),set(837,1210),set(1236,1024),get(766),set(1372,
	 * 3088),set(627,1112),set(1067,1928),set(717,571),get(645),set(754,2777),
	 * set(1185,905),set(794,1106),set(1386,331),set(56,848),get(654),get(139),
	 * get(766),get(167),set(793,1817),set(707,2948),set(244,2125),set(596,1060)
	 * ,get(226),set(1192,2994),get(188),get(1234),set(598,330),set(62,3074),set
	 * (1239,2841),get(447),get(443),set(28,1972),get(851),set(593,2578),get(
	 * 1232),set(1069,888),set(69,1423),set(160,1183),get(934),set(217,2412),set
	 * (1270,57),set(125,214),set(395,2373),set(438,2571),set(496,1058),get(336)
	 * ,set(526,514),set(554,2259),set(1116,2872),set(1148,2774),get(1035),get(
	 * 255),set(213,366),get(132),get(1290),get(328),set(297,3197),get(5),set(
	 * 780,1789),set(198,1067),set(1187,771),set(68,2261),set(1236,1417),set(227
	 * ,2806),get(1044),get(288),get(409),get(1069),set(1243,178),set(978,3254),
	 * set(684,96),set(703,1879),set(238,2880),set(757,529),set(586,3075),get(
	 * 1331),get(1344),set(345,2835),set(13,184),set(907,1257),set(1223,1213),
	 * get(782),set(859,1669),set(1362,1497),set(1394,439),set(123,383),set(148,
	 * 2305),set(712,1281),set(1209,904),get(75),get(305),get(19),set(1197,99),
	 * set(502,2916),get(806),set(1170,2002),set(1417,2335),set(1389,2568),set(
	 * 1183,3062),set(853,1928),get(1166),get(733),set(461,3148),get(100),set(
	 * 1200,916),get(335),get(1158),set(685,3227),set(919,260),get(976),get(1188
	 * ),get(1389),set(1385,1702),set(1225,752),get(1040),set(423,1319),set(1299
	 * ,1578),set(473,500),set(458,950),get(113),set(915,1974),get(815),set(455,
	 * 3191),get(685),get(519),set(208,257),set(161,2461),get(568),get(1272),get
	 * (1181),set(109,791),set(1381,2615),get(845),set(784,2510),get(245),set(
	 * 522,2313),get(640),set(480,200),get(806),get(1009),set(274,1381),set(65,
	 * 3034),set(676,3135),set(900,2050),get(126),get(380),get(132),set(515,871)
	 * ,get(1217),set(1301,2588),get(709),set(430,80),set(699,636),set(28,2592),
	 * set(1247,344),set(755,1645),get(932),get(494),set(1322,838),set(1072,1721
	 * ),get(231),set(1099,2233),set(302,681),get(636),get(854),get(992),get(
	 * 1019),set(1128,1910),set(579,2699),get(1335),set(938,815),get(1417),get(
	 * 598),set(958,2348),set(141,2559),get(451),get(722),set(455,42),get(451),
	 * set(294,1017),get(1287),set(395,1032),set(731,436),set(784,1234),set(1401
	 * ,2354),set(218,2871),get(752),set(944,2009),get(643),get(1126),get(1374),
	 * set(16,2653),set(944,959),set(1034,1621),get(1416),set(80,2043),get(123),
	 * set(555,1679),set(887,890),set(981,646),set(814,161),set(957,146),set(397
	 * ,3216),set(1380,2872),get(1318),get(597),get(723),set(295,2728),get(279),
	 * set(250,1132),get(1108),get(609),get(97),get(481),set(200,467),get(77),
	 * set(1274,2055),get(1084),set(891,1101),set(39,416),get(937),get(291),set(
	 * 1286,1720),set(18,1117),set(533,2820),set(548,329),set(1425,743),set(923,
	 * 842),get(777),get(1209),set(938,1544),set(915,3283),set(359,830),get(530)
	 * ,set(542,55),set(1195,2936),set(730,1269),set(189,2948),get(282),set(925,
	 * 2473),set(1207,873),get(702),get(310),set(1293,1365),get(603),set(1423,
	 * 2453),set(1090,2639),get(499),get(271),set(1408,723),get(1061),get(1189),
	 * get(1358),set(95,2106),set(1299,901),set(1162,2483),get(786),get(164),set
	 * (1315,1094),set(1103,302),get(1315),get(678),set(944,1230),get(878),get(
	 * 695),get(551),get(24),set(446,1320),get(631),get(252),get(1007),set(740,
	 * 1620),set(733,251),set(716,770),get(1387),get(24),set(485,877),set(700,
	 * 832),get(316),set(791,1162),set(1214,1367),set(511,1552),get(1001),set(
	 * 1398,35),set(1272,1125),set(878,2442),set(457,1746),set(1069,1825),get(
	 * 217),get(449),get(478),get(1002),get(969),set(845,698),get(1184),get(869)
	 * ,set(1091,2473),get(1422),get(120),set(750,2823),set(270,1333),get(963),
	 * set(1125,298),set(857,667),set(1204,1807),set(835,2082),set(1082,315),set
	 * (802,1222),set(1203,693),get(1180),get(383),get(460),get(212),set(1126,
	 * 3300),get(1122),get(353),get(258),set(1290,2022),get(1013),set(260,1500),
	 * get(1013),get(521),get(1318),get(744),get(25),set(240,601),set(822,928),
	 * get(314),set(1383,1320),get(154),set(367,2281),get(791),set(257,1873),set
	 * (387,722),get(224),get(667),set(702,1456),set(1308,2833),get(466),get(831
	 * ),set(1281,2333),set(910,2009),set(791,3245),set(232,1568),set(468,2156),
	 * get(194),get(385),set(343,1683),set(66,1329),set(651,1717),set(1088,2202)
	 * ,set(441,2816),set(28,1707),set(571,1138),get(347),set(839,2365),set(510,
	 * 2512),set(261,1593),get(842),get(496),get(1340),set(894,2138),set(677,
	 * 1732),set(1133,2114),get(924),get(463),set(990,163),set(347,554),set(591,
	 * 2361),get(130),get(837),get(1264),set(621,10),get(2),get(1116),set(1121,
	 * 2955),set(842,1122),set(1315,2031),get(147),get(1230),get(483),set(444,
	 * 1275),set(1426,673),set(515,941),set(900,787),get(1252),set(934,1919),set
	 * (905,1181),set(83,50),set(1327,1901),get(652),get(292),get(34),set(556,
	 * 2888),set(944,2829),set(1264,2231),set(1322,2109),get(237),get(124),get(
	 * 1099),get(895),set(529,2251),set(1308,2686),set(610,1639),get(1239),set(
	 * 1029,1589),set(988,334),set(204,923),set(645,1955),set(592,2075),get(783)
	 * ,get(545),set(750,987),get(767),set(555,820),get(823),get(1245),get(105),
	 * set(668,649),set(438,598),get(1393),set(634,1670),get(686),get(172),get(
	 * 316),get(397),set(50,2199),set(120,719),set(1398,74),set(829,2362),get(
	 * 688),get(332),set(692,1557),get(1348),set(506,1084),get(787),get(1429),
	 * get(1118),set(1384,2262),get(858),set(1192,3108),set(50,512),set(80,3135)
	 * ,set(578,3131),get(1236),set(1056,2535),get(489),set(1129,1518),set(1419,
	 * 1134),set(1149,1107),get(245),set(315,18),set(574,119),set(608,1029),set(
	 * 228,41),get(598),set(249,796),get(413),set(1006,128),set(678,2035),get(
	 * 856),set(600,3067),get(265),get(624),set(713,2190),get(1045),set(650,1605
	 * ),get(1106),get(1428),get(243),get(1103),get(956),get(508),set(732,2049),
	 * set(1424,1148),set(657,1974),get(511),get(47),set(659,1196),get(865),get(
	 * 120),set(929,630),set(410,1038),get(1160),get(1048),set(688,1682),get(215
	 * ),get(1326),set(255,342),set(537,1732),set(828,100),get(27),set(637,1961)
	 * ,get(197),get(37),set(837,3273),set(1340,3058),get(1211),get(628),set(357
	 * ,166),set(1375,2556),get(125),get(501),set(69,2402),set(290,2138),set(679
	 * ,1225),set(306,893),get(780),set(1413,2640),set(623,1655),set(852,821),
	 * set(726,3197),get(1090),set(254,2821),get(55),set(1125,1802),set(346,2656
	 * ),set(272,1498),set(931,3073),get(453),get(1141),set(1046,1128),get(739),
	 * set(187,2068),set(952,2706),get(901),set(753,2966),get(799),get(55),set(
	 * 1363,1487),set(651,1621),set(694,1066),set(981,2294),get(24),get(182),get
	 * (600),set(324,1622),set(753,1039),set(885,2618),set(200,249),set(280,1470
	 * ),set(1218,3037),set(505,2612),get(839),set(786,1397),set(851,91),set(377
	 * ,2867),set(904,2183),get(781),set(153,2360),set(837,2938),get(1110),set(
	 * 872,1106),get(1425),set(912,3133),get(107),set(435,1222),set(293,104),get
	 * (987),set(442,1190),set(430,1677),set(416,140),get(461),get(495),set(1214
	 * ,2826),set(727,2122),get(955),set(1012,636),set(338,161),set(989,1904),
	 * get(46),get(1204),get(133),get(1029),get(224),set(491,567),set(287,2393),
	 * set(263,2189),set(376,2003),get(621),get(136),set(462,1622),set(561,2246)
	 * ,set(1337,589),get(619),get(1405),get(274),set(705,1330),get(600),get(
	 * 1016),set(1207,1572),set(1237,358),get(71),set(863,1156),set(58,638),set(
	 * 530,292),set(5,3155),set(199,2844),get(119),get(130),get(1364),get(429),
	 * set(698,797),get(142),set(948,2163),get(1381),set(686,2619),get(470),set(
	 * 696,2054),get(1396),set(498,3092),set(1012,1910),set(164,2796),get(674),
	 * set(328,2037),get(1286),set(697,938),get(1289),set(125,3138),set(1420,
	 * 2427),set(890,68),set(136,5),set(587,2079),set(87,318),get(1257),set(1322
	 * ,1604),set(141,2598),get(1420),get(787),set(1179,380),set(754,1958),set(
	 * 191,458),set(679,2195),get(813),set(1249,1702),get(1291),get(855),set(
	 * 1111,2336),get(1137),get(1401),get(1130),set(834,1816),set(882,658),get(
	 * 1371),set(243,2627),set(1348,1096),set(1362,3074),get(202),set(980,3199),
	 * set(216,135),set(146,2671),set(190,1849),set(1413,2250),set(1097,1473),
	 * get(481),set(493,2956),set(918,2920),set(292,3287),get(996),set(29,2749),
	 * set(1091,1313),set(917,576),set(756,2000),get(9),set(83,1276),set(991,
	 * 1150),get(858),set(1393,2683),get(710),get(674),set(481,525),set(1356,466
	 * ),get(79),set(489,2742),set(1405,433),set(1223,2120),get(1114),set(254,
	 * 2505),get(1071),get(215),get(615),set(152,2472),set(915,1520),get(1005),
	 * get(1166),set(918,1367),get(1126),get(1073),set(1208,1276),set(245,2238),
	 * set(86,395),set(930,193),get(489),set(564,2837),set(181,385),set(67,2673)
	 * ,get(450),get(257),set(880,3132),get(685),get(519),set(1082,2986),get(
	 * 1004),set(339,1993),set(1258,2245),set(585,3253),get(1399),set(1181,2041)
	 * ,get(646),get(101),set(22,1277),get(1107),get(398),get(728),get(56),get(
	 * 750),get(1034),get(886),set(282,115),set(423,138),set(980,1278),set(1250,
	 * 3147),get(573),get(239),set(1159,1619),set(632,1847),get(605),get(1035),
	 * get(76),set(1177,2079),get(1039),set(966,1667),set(49,1534),get(793),get(
	 * 1087),set(107,3120),get(1360),set(965,1134),get(1404),set(1430,2558),set(
	 * 1029,902),set(588,3282),set(1359,255),set(1038,3250),get(74),set(9,2537),
	 * get(97),get(886),set(304,2011),get(532),set(1064,1393),set(1194,2608),get
	 * (326),get(1077),set(41,1109),get(131),get(1245),get(1429),get(718),get(
	 * 290),set(568,3297),set(869,189),get(439),set(424,1698),set(187,874),set(
	 * 402,3),set(1112,820),get(456),get(481),get(199),get(641),get(999),set(529
	 * ,1373),set(796,2677),get(837),get(868),set(80,2176),get(924),set(660,2278
	 * ),set(292,441),get(1376),set(753,2966),set(340,2262),get(871),set(568,186
	 * ),set(267,2976),get(259),set(677,3223),set(211,2635),get(1116),get(109),
	 * set(533,2375),set(270,1617),set(648,1632),set(529,2522),get(1277),set(728
	 * ,189),set(45,1094),get(708),get(431),get(1252),set(1108,2692),set(1087,9)
	 * ,get(831),get(203),set(1422,90),set(606,2589),get(105),set(987,3257),set(
	 * 357,2184),set(18,2470),set(1334,2277),get(1221),set(79,1656),get(949),get
	 * (318),set(350,3172),get(438),get(307),set(942,128),set(18,538),set(458,
	 * 2546),get(725),get(497),set(257,344),set(1352,1375),set(273,1505),get(765
	 * ),get(176),set(661,567),set(1039,1557),set(1240,658),set(527,2533),get(
	 * 248),get(324),get(928),set(280,3180),set(1299,1735),set(145,112),get(1414
	 * ),set(1160,3258),set(639,2974),get(5),set(164,1569),set(399,3196),set(
	 * 1099,2886),set(524,3234),get(1378),set(307,2002),get(484),set(193,545),
	 * set(1212,944),set(607,1265),get(643),get(513),get(1151),get(1119),set(243
	 * ,873),set(627,2972),set(824,1784),set(884,3181),set(1048,2991),get(67),
	 * set(1021,861),set(557,266),get(775),set(76,3052),get(715),set(290,2579),
	 * set(482,1789),get(469),set(1088,1408),set(499,2869),get(1193),set(908,
	 * 1643),set(785,246),get(307),get(785),set(1265,2493),get(341),get(554),set
	 * (2,2150),get(1142),get(1147),get(965),set(979,2870),set(1080,2853),set(
	 * 344,2001),set(1002,1918),set(292,2321),get(1401),get(348),set(1408,372),
	 * get(232),set(773,2274),get(1365),get(720),get(606),set(1395,1425),get(
	 * 1088),set(571,2601),set(1220,2612),get(1400),set(136,2688),set(892,375),
	 * set(678,2216),set(632,260),get(427),set(696,2552),get(1026),get(721),set(
	 * 1163,291),set(1094,1795),set(190,1041),set(1164,10),set(202,292),set(707,
	 * 1192),set(1307,3122),set(1338,1805),get(1365),set(447,1840),set(531,3201)
	 * ,set(704,477),get(606),set(749,2745),get(812),set(1298,2806),set(272,3265
	 * ),set(102,947),get(825),get(796),get(229),set(224,1110),set(134,3265),set
	 * (1370,913),set(1338,2397),set(40,1117),get(1397),set(890,565),get(1194),
	 * get(90),get(68),set(1152,2946),get(276),set(1152,1195),get(436),set(177,
	 * 898),get(1075),set(1065,2123),set(1351,1515),get(1121),get(381),set(377,
	 * 27),get(1141),get(994),set(1302,3010),set(1401,1133),set(338,66),set(824,
	 * 722),get(311),set(27,2400),set(663,2751),set(1195,2940),get(747),get(1320
	 * ),get(955),set(32,2226),set(970,2586),set(145,2527),get(307),set(1424,
	 * 2119),set(965,2709),set(699,2630),set(158,2369),set(79,272),set(626,1859)
	 * ,get(54),get(572),get(42),get(463),set(575,1181),set(276,3120),set(695,
	 * 769),get(395),set(197,1144),get(899),get(1273),set(447,1840),set(385,2031
	 * ),set(661,3291),get(709),set(1166,524),set(941,2093),set(727,2957),set(
	 * 1165,2501),set(1223,2321),set(1121,3065),get(1167),set(927,2284),set(793,
	 * 602),set(916,43),set(761,2419),get(524),set(1094,2623),get(1014),set(1376
	 * ,2603),get(1175),set(885,354),set(779,2287),get(1357),get(1244),get(747),
	 * get(1300),set(503,2061),set(320,1508),set(685,3297),get(792),set(1343,
	 * 1250),set(1176,469),set(889,2016),set(1398,2758),set(602,1240),get(1244),
	 * set(488,1351),set(1373,3159),get(599),set(38,891),get(293),set(311,2701),
	 * get(650),get(374),set(519,625),get(920),set(1267,2056),set(224,1413),get(
	 * 688),set(324,978),get(868),set(1282,1908),set(537,535),get(78),set(1204,
	 * 2371),set(885,2710),set(782,538),set(1161,1281),get(1195),set(128,578),
	 * get(1192),set(814,68),set(402,2470),set(1186,1756),get(441),set(461,477),
	 * set(838,127),get(567),set(1060,3254),set(1390,2728),set(950,1479),set(687
	 * ,718),get(150),set(19,2810),set(372,2530),get(465),get(335),set(1344,20),
	 * set(503,2046),set(3,1847),get(1365),get(1351),set(145,545),get(126),set(
	 * 835,2005),set(1309,2242),get(925),get(724),set(513,59),get(123),set(131,
	 * 1884),set(733,1878),set(507,1957),set(146,2027),get(717),get(84),get(222)
	 * ,set(1081,1337),set(633,314),get(945),get(836),get(863),set(1180,1385),
	 * get(1312),get(52),set(709,805),get(895),get(269),get(273),set(835,838),
	 * get(1054),get(993),set(31,1260),set(1002,1453),get(280),get(101),set(267,
	 * 415),set(808,690),set(640,1243),set(733,2622),set(626,3030),get(1174),set
	 * (419,1788),get(97),set(712,287),get(332),get(51),set(905,1359),get(1057),
	 * set(1271,402),set(1019,2250),get(1237),set(1347,3169),set(1155,1582),set(
	 * 1402,1788),set(850,2326),get(1240),get(752),get(244),set(1228,881),get(
	 * 695),set(531,2399),set(821,2639),set(591,199),set(109,1426),get(456),set(
	 * 977,1892),set(154,2916),set(594,698),set(473,58),set(388,835),set(1103,
	 * 3085),get(1310),set(953,1178),get(376),get(179),get(1156),set(644,59),set
	 * (106,2368),set(477,38),set(766,2698),set(1381,204),set(422,356),set(991,
	 * 34),set(479,2263),set(823,698),get(454),get(114),set(464,2132),set(1248,
	 * 2831),set(1405,2942),set(1062,282),get(511),set(662,1624),set(1317,1083),
	 * get(525),get(33),set(706,1745),set(1380,1827),set(787,3287),set(360,1313)
	 * ,set(1152,666),set(568,602),set(387,2018),set(783,2675),get(633),set(388,
	 * 1353),set(675,3040),set(762,1229),get(558),set(852,339),set(237,499),set(
	 * 302,893),set(42,672),set(468,1065),get(340),set(27,1081),set(455,522),get
	 * (706),set(866,1511),get(1330),set(976,1245),set(316,2990),get(1031),get(
	 * 1199),get(1038),get(903),set(987,734),set(1372,1944),get(37),set(983,843)
	 * ,set(944,2500),get(117),get(790),set(1105,91),set(902,3223),get(983),set(
	 * 1268,2059),set(442,325),set(1365,2725),set(711,1856),get(612),set(259,
	 * 2927),get(1166),set(226,893),set(1427,814),get(10),set(336,1853),set(71,
	 * 31),get(893),get(1269),set(389,2568),get(487),set(1422,3027),set(460,1030
	 * ),set(190,50),get(1093),set(31,3278),set(957,1795),set(1309,900),get(1386
	 * ),get(199),set(204,232),set(1365,1206),get(621),get(598),get(1215),set(
	 * 113,945),get(678),get(117),get(775),set(1005,1129),get(9),set(971,59),get
	 * (193),set(862,1572),set(203,488),set(586,3038),set(1229,33),set(871,2777)
	 * ,set(973,2925),get(1214),set(1156,1492),get(1149),get(1122),set(516,1451)
	 * ,get(1222),set(834,1584),get(283),set(718,1517),get(548),get(1167),set(
	 * 334,1933),set(1410,1502),set(833,701),get(567),set(453,2998),get(767),get
	 * (1335),set(560,10),get(1427),set(1227,2966),get(1339),get(572),get(101),
	 * get(777),set(532,2214),get(1126),get(1122),get(1142),set(685,2033),get(
	 * 1411),set(677,91),get(1058),set(213,2402),get(22),set(44,3062),set(1169,
	 * 418),get(1227),get(420),get(1163),get(234),get(249),get(52),get(688),get(
	 * 771),get(479),set(288,231),set(20,196),set(867,1690),get(677),set(239,
	 * 2188),set(1215,769),set(1142,1070),get(799),set(1188,2127),get(1253),get(
	 * 388),set(207,1014),get(817),set(1031,1951),set(1053,2011),set(892,2784),
	 * get(1322),set(1029,2569),get(755),set(460,2098),set(1063,1127),set(719,
	 * 3169),set(1095,3152),get(827),get(125),get(935),set(926,1848),get(761),
	 * set(207,1773),set(1370,463),set(1328,280),set(1122,614),set(1192,1254),
	 * set(298,1141),set(439,2280),set(1060,1454),set(741,204),set(363,456),set(
	 * 39,384),get(603),set(97,520),set(384,529),set(1040,2377),get(906),get(
	 * 1069),set(1263,1786),get(1426),get(419),set(1286,3276),get(88),get(185),
	 * set(917,431),set(1154,345),get(306),get(1209),set(787,2070),get(473),set(
	 * 1126,974),set(721,144),set(1280,1802),set(1044,2351),set(498,303),set(49,
	 * 820),set(247,2467),set(232,47),set(443,1765),set(937,2280),set(204,1269),
	 * get(1385),get(293),set(2,1593),get(506),set(99,2872),get(634),set(521,
	 * 3221),set(414,256),set(1090,2551),set(117,3022),get(592),get(1299),set(
	 * 550,2461),set(683,2297),set(1021,432),set(1059,2029),set(128,3288),get(
	 * 509),get(694),get(270),set(339,2401),set(324,379),set(1114,1387),set(849,
	 * 2764),set(359,2479),get(778),get(575),get(1084),get(821),set(241,1694),
	 * get(1090),set(1220,227),set(133,2666),get(780),get(1207),get(182),get(561
	 * ),set(346,2974),set(378,1292),get(460),set(1187,1399),set(927,3131),set(
	 * 1297,369),get(520),get(923),set(836,849),set(207,824),set(256,1605),get(
	 * 1065),get(474),set(944,1036),get(475),set(630,1300),get(559),set(1348,
	 * 1186),set(1191,2359),get(452),get(937),get(350),set(1125,3124),get(361),
	 * set(539,1760),set(900,2427),get(925),set(863,20),get(1004),get(87),set(
	 * 382,2582),get(708),get(963),set(1207,1558),set(1352,1513),set(425,2451),
	 * set(735,2814),set(547,2695),set(1257,2142),set(702,637),set(83,734),get(
	 * 148),set(974,159),get(572),set(1408,2460),set(1213,896),set(508,2943),get
	 * (1223),get(1285),set(642,907),set(994,1752),set(691,3043),set(955,2529),
	 * set(319,1601),set(1263,789),get(331),set(83,903),get(268),get(114),set(
	 * 307,717),set(522,1269),set(623,1100),set(387,499),get(624),get(800),get(
	 * 341),get(481),set(331,1161),set(406,3014),set(858,604),set(541,399),get(
	 * 770),set(93,227),set(55,3207),set(1283,461),set(1250,1345),set(1293,2596)
	 * ,set(906,1165),set(815,3086),get(1052),set(45,1251),get(695),set(1228,
	 * 1149),set(160,154),set(775,976),set(728,1425),get(478),set(1095,3006),get
	 * (286),get(773),set(923,2977),get(946),get(267),get(119),get(929),get(1282
	 * ),get(953),set(888,286),set(1016,2467),get(617),get(658),get(425),get(463
	 * ),get(767),get(617),set(344,1589),get(1036),get(1017),set(1328,2525),set(
	 * 1114,1213),get(665),set(1420,1719),set(573,2523),get(203),get(676),set(45
	 * ,1152),get(853),get(518),set(737,2488),get(862),set(462,1152),set(425,
	 * 2414),get(382),set(667,352),get(638),set(1412,2780),set(1045,1513),set(
	 * 1191,799),get(939),get(79),get(476),set(1020,2916),get(1045),set(1255,653
	 * ),get(862),get(324),set(862,1581),get(1216),get(498),get(1187),get(76),
	 * get(963),set(1272,510),set(752,1301),get(630),get(737),get(792),set(740,
	 * 3148),set(613,1699),get(42),get(538),get(185),set(1017,2205),get(785),set
	 * (1072,1667),set(1345,3250),set(608,892),set(893,1254),set(759,1595),set(
	 * 435,1962),set(491,2597),get(1228),get(253),set(332,1816),set(1205,2683),
	 * set(243,44),set(577,565),set(1364,1267),set(583,3031),set(1427,1392),get(
	 * 1346),set(360,1195),set(306,3301),get(387),get(1264),set(1373,2863),get(
	 * 1093),get(727),get(58),set(178,2166),get(357),set(1311,3121),set(1426,
	 * 2341),set(153,3264),set(346,656),set(751,670),get(369),get(680),set(1162,
	 * 834),get(1243),set(598,453),get(888),set(562,3032),set(711,1459),get(895)
	 * ,get(757),get(531),set(545,2308),set(770,2882),get(979),set(648,1094),get
	 * (552),set(996,1762),get(1409),get(220),set(1244,2076),set(209,1634),get(
	 * 324),set(1136,3009),get(1190),get(886),set(32,87),get(1387),set(918,2141)
	 * ,get(479),set(320,2747),set(1219,1272),get(319),set(906,2168),set(486,
	 * 2639),get(758),get(1364),set(318,2307),get(1426),get(64),get(1317),set(
	 * 750,160),set(59,982),set(884,2112),set(454,378),set(456,3053),set(711,
	 * 2184),set(566,125),set(28,3134),get(1241),set(82,509),get(520),get(1166),
	 * get(1338),set(44,1062),set(1404,820),get(901),set(244,860),set(141,604),
	 * set(33,1168),set(110,1884),get(1079),set(585,410),get(254),set(364,3194),
	 * set(1346,1362),get(287),set(287,2849),set(1168,2031),set(584,2392),set(
	 * 1210,3172),set(569,2151),get(192),set(268,2964),get(1429),get(1178),set(
	 * 405,3033),get(581),get(580),set(28,2974),get(51),get(1354),set(129,2144),
	 * set(313,527),set(20,3014),get(273),get(592),set(29,422),set(1430,1211),
	 * get(1280),set(119,260),set(549,2606),get(1130),set(1031,42),get(1257),get
	 * (574),get(1215),get(341),set(716,2809),set(14,2376),set(891,1992),set(530
	 * ,2235),set(950,764),get(1196),set(1221,2333),set(1114,817),get(543),set(
	 * 968,1572),set(285,1945),set(650,2408),set(23,1384),set(917,3076),get(498)
	 * ,get(27),get(637),set(249,2697),set(417,390),set(579,2321),get(273),set(
	 * 294,1665),set(657,2328),set(692,1189),set(1355,1926),set(889,2201),set(
	 * 335,696),set(1238,774),get(188),set(163,333),get(1194),get(702),set(556,
	 * 2326),set(621,521),get(15),get(1099),get(352),set(1291,2163),get(767),get
	 * (669),get(1373),set(153,205),get(1144),get(1412),set(1356,2909),set(644,
	 * 2859),set(478,1649),get(1320),set(1184,2890),set(1242,779),set(1258,2831)
	 * ,set(886,1409),set(378,461),set(551,57),get(413),set(1233,2007),set(245,
	 * 198),get(250),get(143),set(1208,1165),set(272,1624),set(161,2780),set(751
	 * ,197),get(958),get(1343),get(266),get(425),get(1220),get(724),get(56),get
	 * (271),set(709,1401),set(621,1354),get(784),get(969),set(1107,731),get(
	 * 1385),set(978,1806),get(1042),get(1344),get(77),set(237,2119),get(897),
	 * set(1107,428),set(71,177),set(1094,3101),set(396,1565),set(842,2670),set(
	 * 667,167),set(627,1239),set(975,1198),get(8),set(633,894),get(1377),set(
	 * 307,802),set(355,108),get(429),get(220),set(1415,2220),get(324),set(1313,
	 * 3291),get(641),set(581,2772),get(564),set(64,1339),get(601),set(895,502),
	 * set(1414,933),set(61,3084),set(1168,3141),get(1129),set(336,3116),get(777
	 * ),get(397),set(977,2294),set(603,1665),set(147,1721),set(227,1687),get(
	 * 440),set(707,1807),get(946),set(1407,1262),set(878,2863),get(476),set(392
	 * ,1796),set(234,1081),get(1042),set(357,430),get(642),set(1417,2974),set(
	 * 59,812),get(26),set(24,1048),set(1261,1192),set(395,1245),get(1188),set(
	 * 767,2973),set(1007,2602),set(199,1865),set(326,873),get(1403),get(203),
	 * set(132,2160),set(246,1951),set(1069,2758),get(1070),set(882,2733),set(
	 * 1312,2397),set(230,2432),set(769,1730),get(762),set(945,1947),set(1416,
	 * 1260),get(1431),get(1351),get(628),get(748),set(1258,376),set(753,2967),
	 * get(1135),set(134,86),set(682,493),set(243,2196),set(173,347),set(881,
	 * 1890),set(1130,210),set(1335,2630),set(113,975),get(947),set(686,61),set(
	 * 341,1796),get(943),set(620,2149),get(605),get(631),set(1270,1966),get(
	 * 1155),set(125,1717),get(773),set(548,72),get(814),get(759),set(796,2279),
	 * get(1354),get(113),set(607,925),set(645,702),get(1199),set(69,1838),set(
	 * 867,206),set(565,1628),get(382),get(20),get(1396),set(71,2529),set(420,
	 * 1264),set(762,633),get(360),set(150,62),get(66),set(544,204),get(671),set
	 * (1013,2099),set(1092,2774),get(1),set(613,798),get(1133),get(1068),set(
	 * 1028,1136),set(987,3020),get(826),get(42),get(1128),set(417,1333),get(1),
	 * set(872,340),set(1215,2002),get(746),set(505,1948),get(970),get(558),get(
	 * 909),set(1239,105),get(1301),set(1080,1483),get(1107),get(903),set(628,
	 * 2856),set(1107,3250),set(333,370),get(128),set(1307,762),get(625),get(791
	 * ),set(30,1669),get(924),get(887),set(84,1753),set(184,2109),set(43,1615),
	 * get(606),set(459,870),set(821,1533),set(396,1973),set(325,3086),get(1050)
	 * ,set(162,1829),set(314,2390),get(1001),set(1249,1220),get(586),get(201),
	 * set(589,1681),get(239),get(48),set(753,2392),get(19),set(641,2867),set(37
	 * ,2819),set(537,786),get(889),set(33,906),set(327,2044),get(1364),set(743,
	 * 817),set(750,1258),set(42,3084),set(1307,2168),set(127,3086),get(70),set(
	 * 757,138),get(30),set(649,2972),set(1179,156),set(998,1018),set(1078,552),
	 * get(89),get(134),get(1141),set(1330,2007),get(120),get(421),set(574,2772)
	 * ,set(16,2426),get(262),set(1410,1757),get(521),set(464,1019),get(620),get
	 * (290),set(1018,2431),get(358),get(246),get(979),set(604,2056),set(453,885
	 * ),set(1147,3148),get(807),get(1173),set(198,1768),get(151),set(966,2364),
	 * get(414),get(985),set(1309,1428),set(1190,686),get(32),get(997),get(811),
	 * set(517,1795),get(1313),set(1120,1780),set(885,2708),set(42,389),set(643,
	 * 3207),set(1192,1544),set(488,1341),set(431,2352),set(282,3217),set(652,
	 * 2691),set(1040,1294),set(1040,2228),get(129),get(299),get(1109),set(1288,
	 * 206),get(507),set(52,152),set(965,2053),set(1310,2274),set(25,2160),set(
	 * 416,2409),set(901,726),get(1163),set(1222,994),set(828,786),set(210,2868)
	 * ,get(1057),get(1040),set(509,475),get(890),get(240),get(1405),set(998,
	 * 1251),get(774),get(1379),set(1273,2691),set(563,1257),get(883),set(44,
	 * 1822),set(1138,1840),set(704,1332),set(160,2550),set(104,1796),set(659,
	 * 645),set(415,1604),get(1190),get(95),set(1062,1385),get(1064),get(1131),
	 * get(1384),get(1156),get(668),set(605,2408),get(754),set(1420,1551),get(
	 * 1304),get(60),get(1042),set(613,1916),set(1356,571),set(1061,2210),get(
	 * 438),get(1372),set(837,1265),set(684,1656),get(679),get(190),set(669,3091
	 * ),set(421,1152),set(1155,3096),get(1128),set(1267,2839),set(1085,2793),
	 * get(1142),set(1053,3129),set(1060,135),set(366,471),set(793,1056),set(759
	 * ,2643),set(509,746),get(39),get(230),set(933,3210),set(1121,1663),set(719
	 * ,1273),get(1350),set(921,767),set(569,2887),set(422,2546),set(80,1619),
	 * get(856),set(1308,2853),set(869,1802),set(1147,290),get(725),get(1196),
	 * set(748,1010),set(1353,1064),get(593),set(945,2533),get(151),set(1230,428
	 * ),set(99,3211),set(1301,2352),set(1239,2090),set(1246,1913),set(697,1007)
	 * ,set(1211,3302),set(262,2188),set(600,2665),get(253),set(252,615),set(493
	 * ,1623),set(676,3061),set(867,3142),set(747,3007),get(1058),set(898,2521),
	 * set(436,3245),set(1428,616),get(119),set(1335,2641),set(1122,1400),set(
	 * 359,2049),set(1107,2744),set(892,1900),get(1075),set(334,2219),set(821,
	 * 3045),get(1145),set(915,2684),get(395),set(939,676),get(62),set(350,2933)
	 * ,get(800),get(403),set(703,2714),get(845),set(1210,2913),set(962,3108),
	 * set(1011,3222),set(113,1293),get(707),get(876),get(597),set(1151,3224),
	 * set(241,533),get(24),set(595,1381),get(901),set(258,2201),get(705),set(
	 * 251,1310),set(761,1909),get(858),get(273),get(442),get(663),set(1254,2923
	 * ),set(813,468),get(931),set(156,1847),set(1294,443),set(119,2024),get(50)
	 * ,set(846,3048),set(148,2867),set(1042,2173),set(1345,475),set(247,622),
	 * set(238,1181),get(1389),get(303),set(597,3059),get(1321),get(1334),set(
	 * 1093,2665),get(537),get(162),get(178),get(1429),get(902),set(802,807),get
	 * (890),set(674,2418),set(929,2786),get(375),get(485),set(801,2935),set(877
	 * ,683),get(1340),set(709,1252),get(267),get(14),get(668),get(1243),set(982
	 * ,130),set(977,881),set(747,720),set(842,2432),get(1020),set(1186,231),set
	 * (1150,2346),set(1263,2958),set(511,885),set(1201,3241),set(998,2307),set(
	 * 380,1292),set(835,3239),set(511,1184),get(82),get(1195),set(939,1757),set
	 * (1133,3066),set(446,3263),set(562,1649),get(1274),set(1305,90),get(682),
	 * set(497,2799),set(271,2810),set(640,1482),set(760,797),get(940),set(222,
	 * 699),set(667,1956),get(214),get(1214),set(79,774),get(696),get(715),set(
	 * 1171,1299),get(1387),set(787,507),get(1229),get(378),set(487,1948),set(
	 * 352,3277),get(489),set(805,3242),set(131,1198),get(1406),set(294,1966),
	 * get(1175),get(786),get(1155),get(677),set(1360,365),get(1149),get(52),set
	 * (656,1240),set(989,113),set(808,226),set(98,2580),set(1273,716),get(373),
	 * set(949,543),set(1025,2846),get(1388),set(839,2160),set(246,849),set(1143
	 * ,476),get(41),set(1162,1700),set(803,2708),get(834),set(1200,2464),set(
	 * 889,890),set(744,1816),set(461,1647),set(371,2014),set(203,2624),set(1385
	 * ,1192),get(704),get(340),get(1341),set(226,3075),set(921,2591),set(1378,
	 * 2050),set(1410,3106),set(1349,346),get(352),set(1021,2168),get(959),get(
	 * 729),set(785,1100),set(1342,1547),get(1164),set(797,3060),set(512,2617),
	 * set(1384,799),set(507,712),get(1262),get(768),set(484,2898),set(272,2016)
	 * ,set(1033,1454),get(1109),set(1229,3011),set(1277,1237),set(959,3292),get
	 * (11),get(46),set(118,298),get(1059),set(340,247),set(1071,2187),set(129,
	 * 3286),set(188,660),set(375,503),get(527),get(1055),get(1363),set(624,889)
	 * ,set(237,329),get(159),get(575),get(787),set(1247,2804),set(675,1447),set
	 * (1278,2366),get(744),set(1064,1183),set(1183,1603),get(211),set(97,1894),
	 * set(894,1048),set(1395,3138),set(194,2944),set(765,1507),set(1142,3263),
	 * get(829),set(10,480),get(81),get(507),set(1359,2055),set(1072,2406),set(
	 * 43,237),set(34,658),get(942),set(919,3170),get(1210),set(732,2703),get(
	 * 252),get(1297),set(1299,3248),set(685,1820),get(1038),get(4),set(452,2156
	 * ),set(1425,2332),set(936,2369),set(693,1138),get(957),set(825,2722),set(
	 * 614,1021),get(1103),get(163),get(111),get(1138),get(79),get(1109),get(107
	 * ),set(1332,466),set(928,1887),set(68,1108),set(255,2723),get(244),get(117
	 * ),get(407),get(778),set(451,414),get(695),get(24),set(1182,916),set(684,
	 * 1261),get(1304),get(1080),set(1347,49),get(799),set(1073,1769),set(1005,
	 * 3006),set(693,2906),set(622,1531),get(701),set(649,838),set(1321,2021),
	 * set(1355,3017),set(1199,424),set(1197,723),set(974,150),get(1226),get(823
	 * ),set(898,1203),set(155,2159),get(468),get(1286),get(1297),set(338,2421),
	 * get(377),get(608),set(168,1626),get(573),get(36),get(1178),set(662,1840),
	 * set(1308,1223),get(323),get(1251),set(1254,3047),set(501,1815),set(221,11
	 * ),get(425),get(1029),set(1105,865),get(132),set(1319,134),get(1288),get(
	 * 998),set(945,1689),set(1057,1716),get(937),get(604),set(980,2882),set(326
	 * ,608),set(983,1008),get(462),get(1409),set(1131,2104),get(59),set(107,
	 * 3195),set(738,2178),set(998,2730),get(696),set(669,3105),set(1170,471),
	 * set(169,523),set(1008,2684),set(1115,3006),get(125),set(349,1337),set(65,
	 * 358),get(157),set(1414,2192),get(1095),get(749),get(574),get(1242),set(
	 * 1294,2145),set(1233,3273),set(1412,2854),set(15,635),set(209,185),get(
	 * 1410),set(252,2358),set(913,987),set(813,403),set(1063,642),get(310),get(
	 * 39),set(1323,3263),get(191),set(1258,1116),set(65,3115),get(412),set(731,
	 * 2359),get(174),get(54),get(1216),set(172,2799),set(90,2176),get(1119),get
	 * (843),set(176,1642),set(427,7),get(859),set(1185,1878),get(211),set(600,
	 * 765),get(503),get(436),get(919),set(241,821),get(468),get(633),set(609,
	 * 1394),get(1417),set(2,2826),set(147,785),get(1349),get(1053),set(1313,
	 * 2194),get(892),set(181,788),get(228),get(824),get(536),set(275,1349),get(
	 * 1307),set(57,1968),set(127,884),set(564,1113),get(145),set(803,1631),set(
	 * 1131,2849),set(842,2511),get(491),get(1087),get(311),get(1338),get(447),
	 * get(415),set(1180,1761),set(969,932),get(814),set(395,1605),get(981),set(
	 * 772,3240),get(485),set(199,2196),get(1001),get(979),set(113,4),set(90,676
	 * ),get(66),set(838,2770),set(836,49),get(935),set(47,336),set(686,1753),
	 * set(710,2693),set(380,473),get(643),set(430,2317),set(618,1526),set(397,
	 * 3084),set(1117,1622),set(45,3095),set(1373,319),get(489),get(309),get(
	 * 1405),get(940),set(804,2834),set(1060,2051),get(565),get(964),set(236,418
	 * ),get(856),get(611),set(1222,2285),set(156,1786),get(209),set(1188,611),
	 * set(167,1645),get(1003),set(1275,1321),get(122),get(576),set(846,686),get
	 * (54),get(1080),set(599,2946),get(320),set(1308,3114),set(766,754),get(306
	 * ),get(606),get(969),get(1161),set(1128,2117),set(1093,2948),set(472,1847)
	 * ,set(877,1029),get(669),get(544),set(1096,950),get(1404),set(1310,3070),
	 * get(1135),get(1350),set(1239,938),set(1099,2769),get(800),set(1083,1032),
	 * set(622,3045),get(599),set(1193,14),get(1411),get(1064),get(1109),set(
	 * 1173,2377),get(883),get(98),get(274),get(359),set(1019,2750),get(8),get(
	 * 1110),set(1295,2252),set(783,749),get(227),set(1235,828),get(694),set(849
	 * ,1518),set(698,824),set(273,1877),get(1389),get(1410),set(777,1120),get(
	 * 1262),get(21),set(1365,2804),get(536),set(1330,1828),get(431),set(136,
	 * 1254),set(432,2781),get(110),set(1386,2303),set(387,1064),set(688,281),
	 * set(1344,1752),set(1221,980),get(853),get(143),set(124,380),get(1142),get
	 * (727),set(1138,670),set(237,3177),set(106,1938),get(724),set(561,1858),
	 * set(114,1359),set(1381,517),get(18),set(1093,3300),set(1417,70),set(989,
	 * 2111),set(399,1872),set(1379,3088),set(710,2059),set(1233,2077),get(65),
	 * set(222,2223),set(108,1998),set(474,2823),set(412,2842),get(943),get(1044
	 * ),set(1331,755),set(547,45),set(968,2327),set(822,1488),set(1422,2563),
	 * get(624),get(746),get(549),set(122,274),get(39),set(1118,2982),get(1395),
	 * get(726),set(886,1820),set(686,96),set(891,2683),get(1197),set(127,165),
	 * set(135,1151),get(503),set(949,3007),set(566,2432),get(86),set(944,1934),
	 * get(1340),set(267,1894),set(651,1573),set(631,807),set(718,2406),set(513,
	 * 139),get(228),set(305,436),set(57,359),get(570),set(951,446),set(75,2244)
	 * ,set(173,1075),set(550,1123),set(554,2757),set(483,3136),set(1403,1661),
	 * get(588),set(998,1003),set(981,111),get(265),set(506,1136),get(493),get(
	 * 80),set(504,2321),get(1249),get(32),get(800),set(214,1325),set(202,186),
	 * get(85),set(34,883),get(771),set(39,818),set(1090,3100),get(615),get(778)
	 * ,set(1051,1375),set(635,1949),set(1073,433),set(1006,3287),set(835,1513),
	 * get(810),set(1048,1266),get(1009),get(1132),get(40),set(41,1740),get(632)
	 * ,set(463,874),set(725,147),set(987,3275),set(958,3210),get(795),get(673),
	 * get(9),set(913,1218),set(1159,1665),set(1284,1911),get(802),set(415,2135)
	 * ,set(15,104),set(480,1505),get(634),set(202,862),get(929),set(318,2907),
	 * set(1117,1857),set(1224,2521),set(1386,3009),get(285),get(244),get(493),
	 * set(924,1653),get(1225),get(204),get(1012),set(1052,1241),set(726,250),
	 * get(816),get(1171),get(596),get(170),get(1139),get(622),get(985),set(1360
	 * ,753),get(1185),get(143),get(221),get(984),set(1365,2119),set(1292,1008),
	 * set(1246,1391),set(808,1690),get(838),set(888,2905),get(1408),get(256),
	 * set(164,2296),get(359),set(165,695),set(1235,769),get(45),set(978,1008),
	 * get(165),get(1338),get(551),get(117),set(833,2034),get(186),get(1135),get
	 * (336),set(813,3218),get(963),set(617,887),set(479,1402),get(633),get(238)
	 * ,set(106,2912),get(589),set(1212,214),get(1370),set(1026,10),set(885,1280
	 * ),set(1344,2347),get(181),set(1375,3256),set(75,2693),set(1304,259),set(
	 * 998,1659),get(704),get(592),get(895),get(380),get(343),set(381,775),set(
	 * 867,1333),set(633,2950),set(1110,742),set(1026,2497),set(568,497),set(
	 * 1043,2970),get(292),set(92,3176),set(1380,1289),set(1100,2437),get(607),
	 * set(699,2789),set(1112,1050),set(95,2121),set(178,2402),set(1396,2017),
	 * set(512,415),set(195,782),set(1178,1263),set(473,1438),get(1380),get(245)
	 * ,get(703),set(169,2464),get(1273),set(1000,2440),set(1165,2091),set(1054,
	 * 2393),get(130),set(917,2570),get(1327),set(1077,133),get(1054),set(589,
	 * 2334),get(1366),set(128,2067),set(496,1212),get(1000),get(553),set(889,
	 * 2104),get(336),set(838,2856),set(815,1178),set(1304,974),set(1030,1786),
	 * set(1140,699),get(1080),get(73),get(1007),set(1008,1119),get(499),get(276
	 * ),set(213,351),get(481),get(1039),get(828),get(1051),set(815,2806),get(
	 * 334),set(683,2148),set(89,465),set(548,1276),set(1422,1796),set(223,3002)
	 * ,get(371),get(452),get(874),set(953,2010),get(489),get(179),set(983,1909)
	 * ,set(81,1831),get(1199),set(509,356),get(56),get(1255),set(1033,2987),set
	 * (1098,2998),set(397,1836),set(340,1354),set(949,2786),get(1109),set(994,
	 * 2500),get(687),get(1340),set(1374,2158),set(358,255),set(1279,793),set(
	 * 1030,346),get(56),set(589,2178),set(1025,1143),set(1058,2729),set(548,
	 * 2829),set(61,960),get(314),set(723,627),set(636,1677),set(908,1965),get(
	 * 434),set(1271,1422),set(1300,2715),get(1270),get(1351),set(120,1018),set(
	 * 584,2215),set(157,1486),get(141),get(1065),set(722,347),get(1095),get(
	 * 1353),set(549,591),get(1325),set(1317,751),set(928,665),get(1076),get(
	 * 1253),get(1157),get(1390),set(798,1183),set(1410,2939),get(100),set(589,
	 * 80),get(700),set(1383,2059),set(765,1750),set(35,2953),set(538,1743),set(
	 * 846,2538),set(1178,2278),get(559),set(770,1241),set(694,2610),set(1321,
	 * 1781),get(519),set(1194,730),get(1081),set(638,1219),get(356),get(1306),
	 * get(1016),set(1143,89),get(366),set(1198,631),get(971),set(372,457),get(
	 * 1059),set(355,3236),set(450,200),set(198,1681),get(567),set(853,1967),get
	 * (1403),set(873,846),set(427,1049),get(1358),set(235,2161),get(1388),set(
	 * 120,1530),set(747,537),get(599),set(827,2935),get(27),set(272,467),get(
	 * 939),set(947,2643),get(818),set(453,497),set(658,2822),get(602),set(720,
	 * 1605),set(1175,1475),get(464),set(1062,2648),set(478,2377),get(874),set(
	 * 1364,1939),set(957,1244),set(990,1609),set(558,2499),get(634),get(1129),
	 * set(365,748),set(1100,1140),set(937,3268),set(993,3135),set(859,473),get(
	 * 1307),get(798),set(1392,1789),set(128,291),get(157),set(531,1300),get(340
	 * ),set(219,2237),set(741,2205),set(331,3203),set(1170,2415),get(1308),get(
	 * 434),set(601,2749),set(533,224),get(589),set(448,1545),set(147,2244),get(
	 * 93),get(1342),set(1080,3104),get(593),set(190,2737),get(1181),get(1059),
	 * set(603,2646),set(193,371),get(200),get(1338),set(1331,2843),set(1307,369
	 * ),set(97,2330),get(647),set(402,2531),set(1419,851),set(307,875),get(622)
	 * ,get(481),set(665,2568),set(984,2377),get(469),set(397,1201),get(1331),
	 * set(921,144),get(890),get(1278),set(547,2515),set(1427,1435),get(687),get
	 * (1014),get(1285),get(344),set(1122,3046),set(443,1769),set(130,3222),get(
	 * 1205),get(180),set(65,2627),set(421,1774),get(206),get(900),get(956),set(
	 * 433,2945),get(597),set(1147,1542),set(1410,159),set(1235,2221),set(1139,
	 * 2678),get(553),get(680),set(1421,2393),set(842,766),set(834,3105),set(
	 * 1149,824),set(1336,2232),get(376),set(306,500),get(513),set(1254,170),set
	 * (1422,2828),set(702,110),get(1371),set(409,2502),set(1106,887),get(582),
	 * set(747,3184),set(762,2095),set(597,788),set(1238,2933),set(813,816),get(
	 * 1180),get(954),get(835),set(321,594),set(13,2431),set(842,1893),set(971,
	 * 1734),set(353,1913),get(1278),get(1223),get(1297),get(960),get(514),get(
	 * 1025),get(1120),get(508),set(1110,3279),set(123,825),get(559),set(307,736
	 * ),get(578),set(40,3000),set(927,2892),set(1047,888),get(378),set(890,3120
	 * ),set(341,1680),set(1398,279),set(620,1988),set(1370,2410),set(379,2527),
	 * get(164),get(314),set(561,1145),set(833,1244),get(391),set(88,2242),get(
	 * 1266),set(873,2609),get(488),set(1077,2380),get(1018),set(268,251),get(
	 * 996),get(1182),set(29,549),set(67,1274),get(217),set(386,1071),set(87,
	 * 3028),set(516,917),set(297,1442),set(173,1590),set(886,1932),set(1255,
	 * 3289),set(525,761),get(240),get(817),get(624),set(487,283),set(823,3030),
	 * get(1063),set(924,2675),get(164),set(682,2042),get(1375),get(120),set(
	 * 1430,1662),set(50,1248),set(229,2993),set(276,258),get(945),set(1070,2267
	 * ),set(703,2079),set(1290,1925),get(312),set(151,312),get(378),get(309),
	 * set(309,1572),get(1080),set(432,1173),set(185,3080),set(357,691),set(66,
	 * 380),get(47),get(205),get(962),get(265),set(973,213),set(1111,817),get(
	 * 1059),get(1409),set(581,2652),get(959),set(1197,2920),get(552),set(320,
	 * 2352),set(663,1314),get(706),set(367,327),set(930,1636),get(1063),get(40)
	 * ,set(281,567),set(733,1124),get(992),get(951),get(488),set(1384,1460),get
	 * (746),get(1036),set(488,1558),set(353,2306),get(678),set(1020,841),get(60
	 * ),set(311,3168),get(373),set(523,2253),set(368,110),set(923,1280),get(949
	 * ),set(1021,1785),get(1114),set(443,1784),get(889),get(524),get(1094),get(
	 * 1354),get(1113),set(358,731),get(236),set(1155,272),get(95),set(1388,3168
	 * ),set(489,615),set(176,1162),set(68,3031),set(403,1628),get(1251),set(
	 * 1007,606),set(859,594),get(889),get(811),set(578,648),set(428,2613),set(
	 * 497,123),get(1140),get(1335),get(607),set(1360,2795),set(775,364),set(829
	 * ,1534),get(1169),set(65,789),get(311),set(338,80),get(1321),get(909),set(
	 * 993,2471),get(1378),set(999,1374),set(1421,1369),set(932,1301),get(110),
	 * set(665,1332),get(1238),set(1418,3082),set(335,1703),get(333),set(541,
	 * 2234),set(536,2834),get(73),get(310),set(106,3184),get(1130),set(329,3),
	 * set(277,2659),set(333,416),get(511),set(819,2637),set(661,3236),get(849),
	 * get(1253),set(95,843),set(1288,2604),set(1017,2706),set(544,2580),get(
	 * 1392),set(1096,628),set(310,780),get(1204),set(934,619),get(1429),set(707
	 * ,1709),get(1260),set(261,923),get(563),set(68,1374),set(454,1206),set(636
	 * ,1411),get(15),set(337,94),set(420,1076),get(108),set(313,1847),set(1013,
	 * 156),get(66),get(511),get(880),set(675,767),set(242,2313),get(1078),get(
	 * 1133),set(628,426),set(1019,2882),get(630),set(1051,2442),set(1215,2199),
	 * set(747,68),set(860,1135),get(362),get(1310),set(1402,749),set(506,1355),
	 * get(1288),get(1251),set(1073,1059),set(769,1952),set(750,1178),get(1267),
	 * get(1300),set(725,2968),get(586),set(344,335),get(737),set(233,3050),get(
	 * 1235),set(90,74),set(573,2734),set(824,1573),get(760),get(1294),set(1373,
	 * 1627),set(33,1486),set(1272,272),get(798),get(126),set(1166,3191),set(157
	 * ,1069),set(274,1168),set(1325,669),get(960),set(444,2836),get(1317),get(
	 * 365),set(564,566),set(193,1030),get(1326),set(1268,1010),set(1255,1486),
	 * get(701),set(959,2213),get(896),get(967),set(362,1117),get(1393),get(864)
	 * ,get(242),set(973,3219),get(298),set(1287,1537),set(660,1047),set(616,412
	 * ),get(485),get(65),get(1338),set(1407,1825),get(1265),set(1025,2164),set(
	 * 818,1042),set(352,603),get(1355),set(421,1025),set(1274,258),get(468),get
	 * (1342),get(443),set(139,2418),set(385,2140),set(391,2040),get(1132),set(
	 * 203,2371),set(938,1239),get(205),get(1066),get(1368),set(295,1023),set(
	 * 850,2177),set(1425,265),get(66),set(113,1133),set(1038,2215),get(532),get
	 * (1131),get(1247),get(524),set(428,1400),set(903,2133),set(380,8),get(215)
	 * ,set(890,1813),get(936),get(852),set(183,417),get(1218),set(715,585),set(
	 * 557,1001),set(714,1019),set(1296,414),set(480,986),get(1303),get(1194),
	 * set(295,780),set(1139,1560),get(1149),get(1127),set(483,1128),set(901,221
	 * ),get(325),get(1040),set(935,2925),set(219,2034),set(155,1728),get(171),
	 * set(692,1393),get(52),get(1242),set(29,2440),set(1385,2992),set(328,2333)
	 * ,get(952),get(603),set(1243,394),set(325,1869),set(1145,2821),set(667,
	 * 1487),get(711),set(720,1428),get(34),set(1187,1889),set(71,3090),set(202,
	 * 1556),get(1374),set(1281,1100),get(370),set(748,815),set(271,3091),get(
	 * 783),set(909,2815),set(810,206),set(407,614),set(438,2177),set(995,926),
	 * get(146),get(565),get(1378),get(694),set(680,2340),set(134,3065),set(725,
	 * 1769),set(992,2284),set(235,2272),get(924),set(1420,1715),set(649,1422),
	 * set(864,141),get(1252),get(411),set(621,78),get(574),set(285,2353),set(
	 * 1165,1868),get(1428),set(127,146),set(178,2356),get(1218),set(1217,2977),
	 * get(385),get(1129),set(241,2393),get(280),get(1010),set(61,2234),get(1340
	 * ),set(1238,2725),set(469,1569),set(1296,1768),set(1366,2816),get(865),get
	 * (942),set(37,1382),get(346),set(549,2780),get(1428),get(682),get(871),get
	 * (690),set(693,2195),get(274),get(404),get(955),get(75),set(308,2387),set(
	 * 1084,3187),set(931,2344),get(1375),get(1026),get(1049),set(519,1282),set(
	 * 1405,103),set(992,928),set(929,3083),set(667,1939),get(831),get(754),set(
	 * 618,79),set(1290,2417),get(543),set(756,2755),get(994),set(963,397),set(
	 * 826,1176),get(2),get(225),get(479),set(1345,953),set(648,891),get(422),
	 * get(102),get(59),set(538,2705),set(876,3149),set(974,2198),set(324,1668),
	 * get(820),set(35,3025),get(1311),set(517,1906),set(134,537),set(1125,1179)
	 * ,get(657),set(2,291),get(42),get(598),get(1213),get(1182),get(1262),set(
	 * 115,2523),set(507,2760),set(435,563),set(404,1843),get(636),set(1036,1585
	 * ),set(1356,1873),get(357),set(37,3291),get(1208),get(870),get(1390),set(
	 * 108,1090),set(1239,1092),set(68,582),get(504),get(111),set(1226,278),get(
	 * 438),get(1148),set(1205,1424),set(725,2660),set(491,1921),get(1163),set(
	 * 263,2428),set(1421,614),set(572,638),set(1047,288),set(321,2748),get(946)
	 * ,get(352),get(1275),get(993),get(74),get(516),set(548,24),get(628),set(
	 * 1222,2299),set(287,393),set(1135,1485),set(97,1375),get(71),set(1430,1391
	 * ),set(18,2282),set(615,1916),get(1088),get(690),get(1253),get(950),set(
	 * 759,3276),set(893,2175),get(1315),set(580,88),get(440),get(899),set(1153,
	 * 2668),set(759,879),get(1400),set(295,363),get(81),get(1376),set(400,119),
	 * set(866,1352),get(204),get(109),get(146),get(1033),set(744,175),set(778,
	 * 162),get(550),set(149,461),get(1345),set(678,1774),set(788,2059),get(641)
	 * ,get(276),set(1151,173),set(1226,1431),set(1381,1987),set(447,57),get(
	 * 1297),get(1024),get(623),set(1120,467),set(16,1576),set(44,3294),set(1297
	 * ,1578),set(778,2612),set(877,1793),set(449,676),get(867),set(128,2788),
	 * set(1152,3168),get(90),get(59),set(193,1253),get(926),get(1103),set(125,
	 * 580),set(1035,2313),set(890,2560),set(1098,1977),set(1137,128),get(1346),
	 * set(1361,1899),get(829),get(738),set(251,80),get(1116),get(69),get(654),
	 * set(780,2166),get(75),set(378,804),set(396,2567),get(1356),set(811,1154),
	 * set(755,1882),set(230,599),get(1103),set(1373,1134),set(637,791),get(1006
	 * ),set(274,1608),set(566,1020),set(547,1877),set(388,2794),set(1413,1773),
	 * get(844),set(429,2049),set(308,1025),get(1060),set(924,2034),set(1175,
	 * 1124),get(192),set(391,1746),set(1262,2887),get(484),set(1234,3035),set(
	 * 438,3074),get(1208),get(1267),get(64),set(326,1838),set(1215,5),get(225),
	 * get(966),set(936,68),set(475,585),get(1005),set(524,1464),set(1003,1458),
	 * get(338),get(1097),get(1292),get(216),set(405,2535),get(1167),get(1064),
	 * get(394),get(1232),get(699),get(229),set(562,1181),get(827),set(783,3004)
	 * ,get(1040),set(383,3298),get(802),set(1425,257),set(1382,780),set(779,
	 * 2237),set(1419,3269),get(1078),set(329,1382),set(797,1808),get(735),set(
	 * 1290,1996),get(4),get(439),get(539),get(900),set(346,1421),set(861,3046),
	 * get(1047),set(536,929),get(955),get(498),set(978,2208),set(1342,1077),set
	 * (230,2628),set(120,3031),get(768),set(552,226),get(1035),get(169),get(865
	 * ),get(210),set(672,2136),set(14,1907),set(305,2344),set(640,1262),set(315
	 * ,11),set(651,2115),set(127,2590),get(152),set(518,334),set(408,413),get(
	 * 15),get(1383),set(117,2903),set(969,2106),get(129),set(959,2086),get(198)
	 * ,get(346),get(679),set(916,3287),get(1378),set(325,1319),set(562,1003),
	 * set(1249,2295),get(864),set(643,1659),set(758,1404),set(1428,2661),set(
	 * 797,758),set(463,1266),set(441,478),set(445,1058),get(1412),get(1102),set
	 * (649,2046),get(390),set(464,3055),set(652,2060),get(742),get(856),get(394
	 * ),get(1308),set(511,714),set(12,2780),set(935,2484),set(1184,2305),get(
	 * 488),set(121,2576),get(121),get(168),set(50,867),set(1063,2961),set(1198,
	 * 693),set(921,520),get(38),set(151,1235),set(332,1561),set(1203,3090),set(
	 * 604,1337),set(1229,2311),set(1201,1547),get(2),get(825),get(1026),set(
	 * 1241,922),set(939,1307),get(945),set(744,1353),set(612,2530),get(433),get
	 * (113),get(1400),set(1066,1444),set(865,554),get(427),set(567,754),set(566
	 * ,2598),set(1270,1020),get(1001),set(886,2096),set(64,927),get(993),set(
	 * 1209,1831),set(666,1244),set(471,936),get(627),get(469),get(305),set(1193
	 * ,2559),set(702,1701),get(52),get(941),set(1209,2829),get(1261),set(260,
	 * 989),set(1292,1544),get(610),set(616,3231),set(268,695),set(780,2624),set
	 * (547,3091),set(274,3124),set(651,720),get(1135),get(682),set(147,3126),
	 * get(218),set(998,126),set(1210,893),get(1097),get(35),get(1398),set(825,
	 * 2990),get(1121),get(955),set(1038,2019),set(683,1567),set(17,2559),get(
	 * 1276),set(316,2055),get(140),set(1117,216),set(1050,976),get(1372),set(
	 * 1185,1669),set(894,948),get(160),set(760,2746),set(758,2313),get(894),set
	 * (960,548),get(1163),set(950,2059),get(562),set(97,1632),set(1113,1032),
	 * set(1230,3202),set(719,2234),set(114,1758),set(348,1974),get(732),get(643
	 * ),get(113),set(1150,1167),set(995,221),set(1200,1584),get(1318),get(219),
	 * set(561,2470),set(217,3168),get(149),set(820,2241),set(661,924),get(1088)
	 * ,get(447),get(660),get(52),set(646,1427),set(373,1077),set(1324,118),set(
	 * 83,2454),get(92),get(665),set(820,1458),get(465),get(262),set(402,2895),
	 * get(147),set(1358,2064),set(1088,1186),get(799),set(1270,2433),get(995),
	 * set(964,258),get(256),get(1117),get(1214),set(227,1393),set(273,1321),get
	 * (439),get(852),get(524),get(740),get(145),set(370,1201),get(479),get(133)
	 * ,set(1219,624),get(78),set(100,118),set(832,1838),set(850,2846),set(1394,
	 * 2459),set(1304,1892),get(374),get(561),get(904),set(1119,2781),get(825),
	 * set(1383,3284),set(1120,2714),get(427),get(1236),get(759),set(278,381),
	 * set(641,2882),get(772),set(415,2714),set(1247,59),get(1240),get(1330),get
	 * (1204),set(452,3034),get(5),get(712),set(714,354),get(1297),set(1376,86),
	 * get(895),set(878,1175),get(497),get(367),set(1024,1920),set(415,2137),get
	 * (368),get(78),set(508,1262),set(1206,639),get(46),get(869),get(313),set(
	 * 1312,1669),get(886),get(330),get(920),set(914,927),set(344,847),get(631),
	 * get(256),set(1195,2746),set(411,2506),get(729),set(887,1152),set(602,3182
	 * ),set(984,2962),get(598),set(791,851),get(833),set(1072,1907),set(1126,
	 * 2397),get(548),set(958,1778),set(708,840),set(663,2734),set(42,2052),set(
	 * 937,1083),get(439),set(827,108),set(1077,789),get(34),set(872,1123),set(
	 * 1221,3218),get(456),set(134,2223),set(671,3271),set(86,1525),set(1417,189
	 * ),set(230,1667),get(589),set(299,1134),set(1099,2070),set(598,2018),set(
	 * 376,977),set(395,1426),get(1245),set(662,3),get(903),get(833),set(1229,
	 * 1265),get(181),get(233),get(868),set(1009,1559),set(728,2428),set(707,172
	 * ),get(643),set(884,2688),get(928),get(863),get(805),get(1053),set(1179,
	 * 2397),set(1287,2704),get(56),get(66),set(1326,3056),set(1181,707),set(749
	 * ,1506),set(1009,118),get(900),set(1349,1277),set(834,2714),set(757,626),
	 * set(989,474),get(485),set(1183,1403),set(395,2585),set(1316,2513),set(
	 * 1336,2327),get(507),set(1243,552),set(1185,29),set(38,1312),set(415,1379)
	 * ,get(618),set(1086,375),set(736,2999),set(1263,239),set(105,897),set(532,
	 * 907),get(194),get(1081),set(593,1614),get(106),set(453,312),set(739,1933)
	 * ,set(650,1011),set(818,1839),set(698,680),get(105),get(963),set(85,174),
	 * set(545,2044),get(1429),get(1083),get(1376),set(1037,738),get(1047),set(
	 * 1369,2864),get(885),set(218,856),get(620),set(1106,2376),set(141,957),set
	 * (1327,1847),set(719,2807),set(990,1236),get(1040),get(872),set(1221,1297)
	 * ,get(574),get(1051),set(633,1007),set(1358,2163),set(406,1281),set(1029,
	 * 462),set(975,2878),get(1410),get(163),get(784),set(512,1242),set(454,2556
	 * ),set(880,2141),set(216,2313),set(343,3211),get(909),set(1331,2872),get(
	 * 1372),set(646,3171),get(745),set(139,1840),set(1160,2021),set(1241,2627),
	 * get(1130),set(857,1377),set(332,1754),set(414,607),set(539,2148),get(1219
	 * ),get(325),set(1327,2566),set(831,2844),set(572,2452),get(940),set(280,
	 * 2103),get(210),set(306,1269),get(411),get(1085),get(745),set(403,730),get
	 * (1092),set(646,2537),set(534,111),get(307),set(1224,3063),set(882,50),get
	 * (1150),get(674),set(320,3118),set(1340,1071),get(1292),set(14,1548),set(
	 * 1222,102),set(83,966),set(1391,378),get(528),get(862),get(145),get(564),
	 * set(231,131),get(298),set(36,2902),set(119,2706),get(549),set(1050,2469),
	 * get(244),get(589),set(685,947),set(1036,1403),get(1130),set(941,3303),set
	 * (758,933),set(1170,784),get(244),set(1374,2158),set(751,2987),get(1415),
	 * get(12),set(325,1795),set(1022,92),get(897),set(1424,651),get(937),set(
	 * 303,1972),get(966),get(1410),set(943,1457),set(107,1042),get(1406),get(
	 * 194),get(874),get(101),set(246,2474),set(1323,2268),get(747),set(496,832)
	 * ,set(1047,959),set(967,570),get(741),get(531),set(486,196),get(790),get(
	 * 1195),set(928,1282),get(1127),get(1376),get(1310),get(822),set(1273,918),
	 * get(1210),set(888,2348),get(557),get(1414),get(1045),set(125,1957),set(
	 * 310,934),get(82),get(816),set(453,3213),set(502,1015),set(33,97),set(93,
	 * 754),get(105),set(255,985),set(74,930),set(378,1032),get(1029),get(425),
	 * get(804),set(162,2352),get(1246),get(128),get(1112),set(304,3195),set(496
	 * ,423),set(641,2275),get(20),get(1302),get(1097),get(95),set(814,196),get(
	 * 942),set(1041,1986),get(48),get(477),get(434),set(1223,60),set(1018,820),
	 * get(328),set(1334,2678),set(554,572),get(1270),set(1209,2089),set(869,849
	 * ),set(260,543),set(699,1302),get(251),set(1296,1991),set(632,2203),set(
	 * 738,2773),set(1024,2689),set(1154,2623),set(1379,2353),set(223,765),set(
	 * 628,3024),set(1325,1458),set(946,1148),get(1104),get(1184),get(130),get(
	 * 413),get(855),set(363,253),get(89),set(889,777),get(1014),get(20),get(253
	 * ),set(588,2255),get(1159),set(302,765),get(88),get(614),set(892,3112),set
	 * (266,3029),set(700,1991),set(438,2433),set(318,2602),get(1429),get(118),
	 * set(260,2051),set(1336,388),get(298),set(880,1090),set(1408,1969),get(227
	 * ),set(43,1830),set(845,1361),get(573),set(870,248),get(633),get(478),set(
	 * 1371,711),get(350),set(866,2651),set(934,1070),set(289,2185),set(1023,
	 * 2262),set(1339,1464),get(40),get(764),get(716),get(952),set(974,3297),get
	 * (1014),get(440),get(1296),set(950,403),set(926,1870),set(835,2946),set(
	 * 1124,627),get(852),get(242),get(1398),set(911,498),get(1001),set(1059,
	 * 2653),set(551,2230),get(552),set(938,1235),get(389),set(1064,2448),set(59
	 * ,1336),get(1157),get(1160),set(266,2334),get(728),set(863,1435),get(572),
	 * set(38,3024),set(437,2425),set(1329,605),set(1110,3181),set(1282,3031),
	 * set(742,2150),set(466,136),get(1136),set(695,1556),set(253,2215),get(156)
	 * ,get(762),set(520,2168),get(1255),set(1176,1135),set(771,2131),get(1149),
	 * set(607,874),set(648,2437),get(758),set(506,2691),set(1186,1138),set(169,
	 * 507),set(1241,2599),get(190),set(476,2600),get(260),get(1205),get(136),
	 * set(1091,1254),get(655),get(1065),set(408,213),set(699,1874),set(60,644),
	 * get(399),get(920),get(677),set(871,1246),set(739,1439),get(282),get(152),
	 * get(1176),set(1238,3089),set(91,920),set(698,2069),set(1398,371),set(828,
	 * 1503),get(169),set(1273,3023),get(637),get(472),get(540),get(1211),get(
	 * 263),get(135),set(224,3159),get(1195),get(939),get(640),set(755,2291),set
	 * (924,3224),set(181,792),set(149,2396),set(705,1421),set(1347,1927),get(
	 * 132),get(841),set(262,3060),get(809),set(685,1072),set(441,2572),set(1263
	 * ,2143),set(402,2283),set(156,553),set(896,659),set(1253,2175),get(525),
	 * get(378),set(339,2391),set(1266,35),get(437),get(526),get(1198),set(782,
	 * 195),set(838,2869),set(503,1008),get(72),get(978),get(1228),get(1000),set
	 * (30,1131),set(479,1858),set(160,386),set(842,471),get(934),set(981,1773),
	 * set(141,2990),set(905,1661),get(1260),set(1006,423),get(1156),get(6),set(
	 * 834,1003),get(204),set(1330,233),get(1033),set(770,3224),set(1277,1111),
	 * get(976),get(1169),set(1093,1764),set(774,1133),set(278,314),get(679),get
	 * (1400),get(1314),set(919,23),get(7),set(163,1670),set(702,2772),get(529),
	 * set(47,2411),get(874),get(600),get(765),set(879,1373),set(688,191),set(
	 * 1340,570),set(231,566),set(757,3064),get(460),get(897),set(922,3266),get(
	 * 640),get(143),set(488,726),get(1149),get(1267),get(18),set(613,380),set(
	 * 1053,53),set(1168,1995),get(101),set(48,1340),get(1422),get(983),get(1176
	 * ),get(3),get(775),get(509),set(47,495),get(318),set(228,1092),set(1224,
	 * 1879),get(297),get(26),get(238),get(1050),set(528,1220),get(758),get(269)
	 * ,get(404),get(602),set(609,2212),set(1089,1385),set(5,1139),set(1035,3104
	 * ),set(473,3003),set(1305,3064),set(354,460),get(598),set(606,977),get(
	 * 1249),set(733,1399),get(156),set(712,734),get(1171),get(940),get(1242),
	 * set(1051,2332),set(857,666),set(870,3062),set(1417,299),set(904,195),set(
	 * 1365,639),set(353,952),get(1136),set(454,2854),set(504,2164),set(942,2793
	 * ),get(1250),set(307,887),get(1082),get(1228),set(772,1074),set(1173,1106)
	 * ,get(394),set(656,3180),get(1239),get(449),get(1414),set(531,1744),set(
	 * 1019,1704),set(600,2007),get(1373),set(1318,2422),set(998,452),set(1305,
	 * 2420),get(692),set(186,1140),set(908,2403),set(1353,1087),set(719,1702),
	 * set(841,2557),set(1311,1083),get(647),get(98),get(1363),set(847,590),set(
	 * 570,553),set(1076,2920),set(911,1463),set(1206,1822),get(1114),get(1104),
	 * get(160),set(1204,434),set(1212,3090),set(1373,2737),set(551,329),set(
	 * 1155,25),set(1011,2999),get(1295),get(577),set(69,2868),set(280,233),get(
	 * 382),set(716,563),get(596),set(376,850),set(1355,568),set(626,525),set(
	 * 1289,1632),set(1291,855),get(907),get(461),set(939,191),set(1017,1768),
	 * set(1177,2890),set(628,1481),set(594,2828),get(226),set(353,1864),get(519
	 * ),set(946,270),set(966,2106),get(1375),get(1365),get(717),get(1278),set(
	 * 587,2339),set(46,128),get(1078),set(145,807),set(745,1072),get(318),set(
	 * 1355,1179),get(669),get(1279),get(207),set(298,1819),get(651),set(27,472)
	 * ,set(1368,598),set(1096,3026),get(412),get(987),set(523,2884),get(480),
	 * get(51),get(182),set(1152,1990),set(60,2235),get(693),set(1383,720),set(
	 * 71,3214),set(570,1),set(1365,2513),get(557),set(1334,2268),set(1217,1184)
	 * ,get(798),set(214,2623),set(622,2398),get(674),get(1090),get(204),get(571
	 * ),set(1400,980),set(900,2072),set(635,1722),get(904),get(1243),get(270),
	 * set(1253,22),set(1243,1460),set(1099,101),get(1224),set(1411,2910),set(
	 * 1271,1402),set(645,600),get(50),get(1038),set(123,2910),get(1167),set(
	 * 1123,1033),get(210),set(1124,2917),set(73,794),set(240,2342),set(1098,
	 * 2993),get(715),set(91,283),set(753,1619),set(928,1943),set(248,2944),get(
	 * 851),get(354),set(979,632),set(1373,809),get(718),get(26),get(499),get(
	 * 1030),get(284),set(1143,2268),set(290,647),set(25,2029),set(462,418),set(
	 * 1065,1741),set(882,903),set(155,853),get(816),set(605,2230),get(826),get(
	 * 992),set(1,1620),set(1304,687),set(971,1062),set(798,516),get(1242),set(
	 * 222,2374),set(146,557),get(1407),get(961),set(1409,2898),get(707),get(771
	 * ),get(321),get(1092),get(1008),set(933,617),get(220),get(100),get(540),
	 * set(1417,251),set(527,1635),set(1386,1955),set(639,403),get(1253),get(621
	 * ),get(1324),get(955),get(230),get(1338),set(1399,2165),get(143),set(814,
	 * 1107),get(247),get(1134),get(1069),set(1351,1833),get(637),set(1410,1473)
	 * ,get(538),get(971),set(1214,3217),get(170),set(1054,233),set(919,1267),
	 * set(325,1528),get(447),set(919,2244),set(73,167),set(430,1906),set(1083,
	 * 589),set(1132,279),get(876),get(1189),get(1279),set(1191,3175),get(505),
	 * get(139),get(786),set(818,2691),get(13),set(222,791),set(277,932),get(
	 * 1008),get(89),get(101),set(512,754),get(864),get(649),get(1052),get(987),
	 * get(1216),set(1394,1995),get(375),get(1338),set(276,2215),set(184,2525),
	 * set(853,301),set(1430,2334),get(1381),set(1251,1784),get(223),set(1221,
	 * 1058),get(483),get(1210),get(1372),set(1378,278),set(98,2996),set(161,
	 * 1205),set(805,1608),set(1398,1033),set(1424,940),get(526),get(542),get(
	 * 659),set(229,186),get(110),set(800,1817),set(922,3154),set(1380,2681),set
	 * (850,3090),set(108,131),get(608),get(401),set(1084,227),set(1030,3126),
	 * set(216,571),get(660),get(2),get(1272),set(1166,1796),set(889,24),get(406
	 * ),set(1253,2855),get(277),set(688,2429),set(1238,1813),set(1184,1043),set
	 * (553,217),get(1340),set(792,2441),set(279,2154),set(52,232),set(859,89),
	 * set(1422,847),set(940,989),set(27,226),set(239,965),set(774,3125),set(
	 * 1074,31),get(462),get(252),set(1400,3119),get(782),set(1145,589),set(57,
	 * 2057),set(118,515),get(391),get(1186),get(984),set(477,1254),set(822,870)
	 * ,set(26,1961),get(894),set(143,780),set(590,375),set(415,1382),set(474,
	 * 1142),set(1275,64),get(544),get(104),set(634,806),get(1273),get(1410),get
	 * (669),set(265,704),get(470),set(702,2025),set(638,1587),set(141,3213),get
	 * (586),get(638),get(56),get(713),set(103,1848),get(607),set(1399,2229),set
	 * (965,2620),set(1359,2413),set(720,150),set(789,1214),get(1065),get(587),
	 * set(934,2035),set(855,1027),set(820,279),get(958),set(1078,339),get(756),
	 * get(735),get(831),set(1263,2161),set(270,1463),set(1263,2169),get(130),
	 * get(326),set(777,1938),get(789),set(296,501),get(1430),set(339,1218),set(
	 * 1337,2672),set(1259,2496),set(48,2222),get(80),set(1334,3034),get(293),
	 * get(1334),set(719,1581),get(19),get(1176),set(590,1544),set(506,2523),get
	 * (1051),set(809,337),get(939),set(1129,2127),set(58,371),get(1404),get(290
	 * ),get(1124),get(329),get(1407),get(284),set(801,49),set(339,1184),set(420
	 * ,2627),set(699,2794),get(659),set(103,310),set(742,2182),get(123),set(334
	 * ,2954),get(640),set(1294,2814),set(800,1719),set(812,964),get(963),set(
	 * 1136,408),set(35,418),get(1354),get(1193),get(562),set(339,2066),get(475)
	 * ,set(671,1889),set(1084,3002),set(1308,3173),set(462,1257),get(631),set(
	 * 194,2489),set(1427,2589),set(1382,2173),get(155),set(225,787),set(210,
	 * 2335),set(1080,1548),set(634,993),set(142,2876),set(797,2274),set(842,
	 * 1267),get(864),set(604,1206),set(962,940),set(1144,305),set(119,2618),set
	 * (1012,318),get(688),get(715),get(1060),set(1378,2475),set(825,1249),get(
	 * 1274),set(898,2605),set(797,2087),set(897,118),get(228),set(856,3004),set
	 * (966,3226),set(853,2213),get(14),set(1118,859),get(701),get(463),get(780)
	 * ,set(1269,47),set(930,2195),set(201,715),set(1165,2724),set(421,2154),set
	 * (47,1527),set(24,1744),set(878,2324),set(1126,3101),set(110,2684),get(281
	 * ),get(797),get(148),get(688),set(1309,2578),set(1043,2689),set(1194,165),
	 * set(982,3129),get(831),set(157,2957),get(1124),set(1096,2900),get(246),
	 * get(753),get(1324),get(962),get(449),get(1424),set(95,2461),get(766),set(
	 * 134,2998),set(1138,2299),set(454,764),set(1101,2480),set(1143,2189),get(
	 * 997),get(965),set(60,3025),set(769,902),get(695),set(638,3161),set(49,
	 * 1047),set(1198,3290),set(96,3107),get(1042),set(1289,2682),get(494),set(
	 * 195,324),get(691),get(670),set(822,1620),get(287),set(246,976),get(963),
	 * set(422,546),get(1127),set(1341,1718),set(1053,2929),set(544,1467),set(
	 * 327,2813),set(934,451),get(1387),set(535,999),set(707,1992),get(1296),set
	 * (1010,1032),set(816,1136),get(619),set(55,953),set(599,944),set(1325,2168
	 * ),set(56,937),get(892),get(302),set(290,2394),set(828,3044),get(202),get(
	 * 92),get(826),set(198,1239),get(717),get(1150),get(97),set(265,913),get(
	 * 285),set(223,1131),get(603),get(30),set(804,2510),set(1091,2408),set(564,
	 * 3222),set(46,2801),set(729,1416),set(1130,3236),set(652,237),set(551,525)
	 * ,get(1315),set(395,1167),set(1362,1076),set(58,1724),set(709,760),set(886
	 * ,1918),set(1149,121),set(1139,2579),set(615,2768),set(70,1612),get(273),
	 * get(1301),set(440,2717),set(549,1084),get(556),set(1412,2249),set(34,2324
	 * ),get(802),set(1162,1056),set(1400,3028),get(1301),get(21),set(1275,963),
	 * get(688),get(1020),set(1222,3297),set(975,2024),get(1180),get(373),get(
	 * 803),get(131),get(29),get(640),get(791),get(877),set(284,760),get(262),
	 * set(214,611),get(907),get(759),set(688,2270),get(567),set(358,2134),set(
	 * 829,3282),get(999),get(1168),set(169,1700),get(667),get(316),get(963),get
	 * (1225),get(1122),set(1105,1247),set(1190,1074),set(122,3132),set(1335,740
	 * ),set(428,2046),get(715),get(752),set(763,2566),get(934),set(1072,156),
	 * get(506),set(1402,104),set(345,624),set(1416,2138),set(1412,797),get(497)
	 * ,set(698,105),get(631),set(1325,2348),get(961),set(1278,183),set(445,1701
	 * ),set(371,1966),get(1305),set(1044,1661),set(57,2593),set(1250,1260),set(
	 * 1196,2978),get(908),set(1101,3045),set(583,344),get(1016),set(105,1152),
	 * set(1409,1108),set(787,2372),get(580),set(273,1685),get(1128),get(628),
	 * get(1103),set(821,1647),get(583),set(1100,3244),get(475),get(264),get(
	 * 1265),set(1147,2689),set(188,2907),set(786,2655),get(820),set(502,2604),
	 * get(1268),set(1114,292),set(1356,1238),set(241,1916),set(928,2662),get(
	 * 675),set(259,2530),set(482,227),get(113),get(1086),set(736,2465),set(1284
	 * ,647),set(380,430),get(882),get(1120),set(131,3198),get(1059),get(1375),
	 * set(1115,2958),set(853,212),set(868,3066),set(535,1052),get(1400),get(
	 * 1263),set(55,3007),set(153,1664),set(837,440),set(358,2270),set(1287,2002
	 * ),get(342),get(596),get(278),set(214,1546),set(1215,153),get(526),set(580
	 * ,2446),get(700),set(1306,354),set(761,448),get(357),set(816,2422),set(256
	 * ,2867),get(1147),get(1341),set(567,775),get(1139),get(234),set(1422,1929)
	 * ,set(971,602),get(103),set(1265,498),set(1178,2843),set(1342,2165),get(
	 * 1282),get(223),get(1319),set(777,1342),set(592,1230),set(1282,2133),set(
	 * 1120,3136),get(868),set(296,1838),get(1246),get(723),set(1403,1242),set(
	 * 788,890),get(1333),set(475,2177),set(195,1305),get(1130),get(440),get(
	 * 1332),set(1053,655),set(236,1397),set(159,161),set(870,1590),get(493),set
	 * (1427,1926),get(1197),set(601,478),set(739,1139),set(1327,2408),get(111),
	 * get(1056),set(301,2360),set(862,2498),set(1226,4),get(1408),set(1316,67),
	 * get(1388),set(947,2890),get(377),set(1,2323),get(883),set(1273,3117),set(
	 * 1329,3116),get(704),set(1340,1813),get(287),set(909,3109),set(1240,2229),
	 * set(438,3006),get(1384),set(929,2925),get(28),get(77),set(776,950),set(
	 * 473,2594),set(247,606),get(740),get(121),set(1301,1884),set(1030,1255),
	 * get(328),get(217),get(515),set(697,3159),set(463,827),get(754),get(55),
	 * set(1015,1886),get(373),get(222),get(177),set(702,3195),set(832,951),set(
	 * 831,2999),set(1317,2176),set(1302,998),set(842,141),set(1137,2258),set(85
	 * ,2474),set(440,683),set(687,2182),set(1017,1383),set(322,2306),set(88,
	 * 1726),set(420,764),set(1283,2580),set(848,2814),get(972),set(26,1415),get
	 * (1001),set(311,429),get(612),get(552),set(878,935),get(470),get(865),get(
	 * 51),set(1337,2741),set(1059,1315),get(97),get(743),get(516),get(1157),set
	 * (170,2148),get(21),set(528,1602),set(489,2152),set(358,1578),get(388),set
	 * (1369,1594),get(313),get(89),get(35),set(37,1472),get(643),get(355),set(
	 * 1055,2114),get(913),set(361,1064),set(278,2210),get(642),set(1144,2893),
	 * set(831,897),get(1155),get(536),get(846),get(806),set(116,660),set(596,
	 * 310),set(1370,1890),set(451,2699),set(410,2092),set(1110,1971),set(1356,
	 * 543),set(430,2791),set(1373,1829),set(490,1758),get(767),set(1375,589),
	 * get(1062),get(24),set(931,1418),set(1232,2400),get(1064),get(814),set(370
	 * ,1191),get(738),get(70),set(407,1479),set(380,1290),set(858,2710),get(204
	 * ),set(601,500),set(1321,2947),get(68),set(502,2610),get(1351),set(923,
	 * 2676),set(1338,723),set(665,1100),get(11),set(850,1841),get(142),set(370,
	 * 3248),get(898),set(1331,790),set(449,301),set(615,1054),get(641),get(880)
	 * ,set(388,98),set(857,3227),set(142,3169),get(925),get(470),get(809),get(
	 * 115),set(1426,2109),set(1429,1636),set(1280,2703),get(482),set(1236,971),
	 * get(846),set(261,1623),set(236,1765),set(785,196),get(69),set(1390,2011),
	 * set(1335,2747),get(1021),set(638,622),set(141,2841),set(1030,2088),get(
	 * 1183),set(887,1797),set(660,1372),set(367,1817),set(697,745),set(460,2259
	 * ),set(98,2683),get(1202),get(683),get(774),set(376,2725),set(847,1281),
	 * get(181),set(1214,2089),get(1049),get(870),get(1274),get(920),set(514,
	 * 2898),set(398,559),set(134,816),get(962),get(169),get(169),get(889),set(
	 * 1423,808),get(1221),set(1131,89),get(653),set(352,894),get(231),get(4),
	 * set(56,765),get(1070),set(1382,2274),set(639,1638),set(1118,686),get(339)
	 * ,set(473,2895),get(231),set(1252,2307),set(475,2558),get(800),set(685,
	 * 2291),get(292),get(505),set(66,3127),set(481,676),get(386),set(369,2923),
	 * set(1414,655),get(263),get(716),get(115),get(309),get(1149),get(1266),get
	 * (202),get(597),set(1350,2274),set(375,519),get(1129),get(620),get(231),
	 * get(1098),set(1420,2289),set(246,1038),get(998),set(344,1549),set(342,
	 * 1773),set(552,1013),set(802,2063),get(379),set(777,1771),set(1060,1652),
	 * get(1381),get(134),set(531,1905),get(1390),get(361),set(185,279),set(30,
	 * 607),get(1219),get(263),set(431,476),get(36),set(1344,28),get(484),get(
	 * 1323),set(1341,1373),set(1349,1400),set(312,2751),get(507),set(155,2817),
	 * set(201,593),set(448,1965),set(769,1776),get(397),set(934,708),set(268,
	 * 2292),get(1339),get(341),get(559),get(1290),get(1295),set(160,2646),get(
	 * 689),get(1045),get(891),set(601,1287),set(1029,2455),set(964,1531),set(
	 * 258,39),set(339,159),set(101,2269),set(858,1109),get(403),set(1085,2722),
	 * set(1393,575),get(572),set(807,1760),set(910,921),set(593,2116),set(1165,
	 * 2999),set(992,2286),set(499,199),get(350),set(1361,3141),set(1336,1870),
	 * get(847),get(902),get(916),set(1070,3037),set(307,2843),get(83),get(267),
	 * set(945,1307),get(1303),get(216),set(834,3065),get(1181),get(903),set(194
	 * ,200),set(728,1506),get(659),set(1126,2335),set(624,965),set(318,190),get
	 * (201),get(284),get(597),set(897,2783),get(1230),get(621),set(311,2419),
	 * set(1130,914),get(1134),get(370),set(276,983),set(1373,1004),set(995,2715
	 * ),set(955,160),set(1335,826),set(1311,2375),set(408,957),set(783,3263),
	 * get(665),set(1391,1757),set(776,794),get(568),get(822),set(1054,1219),set
	 * (372,2704),set(1027,1498),get(1332),set(15,1550),get(388),set(1220,1302),
	 * get(1314),get(1056),set(976,1081),get(732),get(583),set(453,1593),get(311
	 * ),set(398,2072),get(145),set(1424,621),set(1227,1754),set(1012,3163),get(
	 * 187),get(1260),get(528),set(295,2320),get(1366),set(644,2820),get(154),
	 * get(857),set(1263,609),get(841),set(1260,3048),set(672,779),set(1156,113)
	 * ,get(530),set(1026,2430),set(401,3215),set(658,1001),set(651,587),set(
	 * 1034,1056),get(608),get(151),set(1165,3243),set(930,3033),get(69),set(518
	 * ,2121),set(367,2581),set(656,1751),set(855,366),get(28),get(1246),set(530
	 * ,2475),get(830),set(1123,1899),set(62,3288),get(760),get(680),set(59,1936
	 * ),set(586,1774),set(488,1089),get(1027),get(1256),get(217),get(1394),get(
	 * 147),set(566,1876),set(222,1011),set(414,2809),get(77),set(1173,2415),get
	 * (533),get(404),get(101),get(957),get(600),set(1245,1134),get(140),set(832
	 * ,2958),get(316),get(473),set(464,1092),set(1163,2477),set(161,953),get(
	 * 1355),set(697,489),set(1359,1219),set(178,2563),get(480),set(1073,184),
	 * get(246),get(1393),get(83),get(439),set(1137,2179),get(992),get(601),get(
	 * 1272),set(867,1169),get(173),set(9,804),set(450,2296),get(216),set(285,
	 * 736),set(1029,508),set(410,2498),set(81,1842),get(1279),set(1363,1863),
	 * get(923),set(1398,3092),set(1050,2034),set(909,2451),set(769,3019),get(
	 * 862),set(828,579),set(1212,2395),set(983,1457),get(699),get(1059),set(851
	 * ,20),set(639,2628),get(663),set(736,1783),set(965,3122),set(564,1458),set
	 * (1154,2094),set(1031,608),set(219,2569),set(652,1539),set(1206,362),get(
	 * 279),set(623,1422),get(1357),set(175,36),set(1065,71),set(413,1127),get(
	 * 651),set(1208,2177),set(776,2929),get(826),get(691),get(1240),set(1159,
	 * 2283),set(260,234),set(1045,752),get(717),get(979),set(1020,561),get(181)
	 * ,set(1394,2778),set(1414,86),get(1330),get(1126),set(807,1794),get(983),
	 * set(241,1550),get(1412),get(562),set(1083,3133),get(1075),get(979),set(
	 * 1033,1049),set(1037,1127),set(1112,2738),set(563,1850),set(1034,2940),set
	 * (97,1020),get(133),set(2,3275),set(557,2626),get(12),get(1087),set(1201,
	 * 1017),set(854,576),set(1008,890),set(622,3303),set(1236,1284),get(1044),
	 * set(101,2606),get(438),set(391,1610),get(36),set(1321,2744),set(886,2608)
	 * ,set(1205,226),set(563,483),set(643,1263),get(205),set(13,2039),set(34,
	 * 789),set(840,1818),set(451,2700),get(325),set(596,3162),get(746),set(903,
	 * 1542),set(987,3165),set(1363,602),set(432,109),set(796,2874),get(711),get
	 * (302),get(1145),set(791,3133),get(735),set(52,2352),set(1091,3299),set(
	 * 831,2255),set(39,3271),set(1026,2798),set(934,2819),get(767),set(639,492)
	 * ,get(317),set(555,3291),get(289),set(1101,809),set(753,933),set(806,2442)
	 * ,get(1358),get(472),set(1109,526),get(1199),get(472),set(332,98),set(1230
	 * ,2970),get(245),get(884),set(1429,2108),set(903,1925),get(1046),set(1128,
	 * 583),set(1381,3088),set(1260,2708),get(461),set(1354,3076),set(511,2445),
	 * set(1065,3236),get(382),set(115,595),get(976),get(657),set(263,1729),set(
	 * 747,809),set(684,1404),get(475),set(518,201),get(1042),set(339,1678),get(
	 * 1322),get(1090),set(704,967),set(380,1805),set(783,2068),get(428),get(7),
	 * set(117,3279),get(293),set(791,2995),set(693,2931),set(867,1673),get(889)
	 * ,set(1409,1161),set(534,1450),set(576,2586),set(131,1955),set(495,3106),
	 * set(466,1271),set(1228,2574),set(718,2965),get(801),get(388),get(1192),
	 * get(1241),set(851,2347),get(1021),set(1267,1619),set(177,772),set(7,778),
	 * get(306),set(844,628),set(195,3022),get(38),set(935,1758),set(1049,1201),
	 * set(415,222),get(1384),get(267),get(865),get(1141),set(424,365),get(567),
	 * get(550),set(1403,1262),get(135),set(755,533),set(251,2475),set(398,3099)
	 * ,set(1091,624),set(280,1322),get(370),set(1218,2763),get(1226),set(1249,
	 * 2899),get(516),set(527,2813),get(99),set(613,2785),set(435,2039),set(135,
	 * 2329),set(263,41),set(968,363),set(984,888),set(1225,652),set(415,1145),
	 * set(733,158),set(17,781),set(441,84),set(430,3116),get(124),set(1413,1781
	 * ),get(1072),set(239,2736),set(981,1878),get(1337),set(1091,1252),set(366,
	 * 462),set(802,1915),get(232),set(1209,715),get(718),get(833),set(1385,2529
	 * ),set(982,2603),set(190,1531),get(1071),set(1074,737),set(1016,2103),get(
	 * 288),set(960,415),set(1105,1349),set(831,1633),set(1173,340),set(580,198)
	 * ,set(176,1195),get(463),get(213),get(108),get(924),set(127,332),get(429),
	 * get(235),set(937,284),get(588),get(880),get(903),get(1339),set(122,460),
	 * get(1381),set(388,1118),set(1385,2375),set(619,724),get(113),get(461),get
	 * (932),get(217),set(976,970),set(956,3214),set(732,603),get(116),set(70,
	 * 226),get(869),set(1376,2187),set(783,1846),get(199),set(662,2917),set(266
	 * ,2420),set(322,542),get(394),get(807),get(1326),get(1320),get(1007),set(
	 * 1196,230),set(534,814),get(739),set(1225,1689),set(680,421),get(133),set(
	 * 1091,1799),set(852,2562),get(400),set(165,2104),set(334,1886),set(530,
	 * 1410),get(954),get(1004),get(778),set(136,2833),set(619,532),get(500),set
	 * (195,681),get(1093),set(833,2703),get(892),set(592,2784),set(40,3157),get
	 * (134),get(175),set(141,1254),set(258,460),set(492,52),get(350),set(639,
	 * 2018),get(34),set(1113,1991),get(138),get(1207),set(1008,992),set(475,998
	 * ),set(526,2771),get(618),get(1222),set(1170,202),set(429,1019),set(1126,
	 * 1520),get(217),set(8,2972),set(843,379),set(612,1704),set(1117,1141),set(
	 * 127,1626),set(332,2051),get(1300),set(1380,1462),set(647,1110),get(1425),
	 * get(493),set(707,1986),set(1384,3208),set(753,436),get(806),set(809,1031)
	 * ,set(216,2159),get(1166),set(586,1222),get(777),get(776),get(1381),set(
	 * 1264,1320),get(1158),set(1272,3005),set(1348,1586),set(1046,961),set(1307
	 * ,29),set(29,3128),get(565),get(8),set(938,1919),set(297,2139),get(968),
	 * set(266,2001),set(11,566),set(915,2274),set(435,1488),get(1095),get(95),
	 * set(800,2567),get(907),get(819),set(922,1566),get(1201),set(908,331),set(
	 * 708,3226),set(1028,2562),get(412),get(823),set(1360,2937),get(907),get(
	 * 1076),get(1368),set(1232,1813),set(78,1866),get(763),set(540,76),get(1314
	 * ),get(1121),set(827,2644),set(224,2088),get(472),set(438,2162),set(898,
	 * 1653),set(1407,1598),set(471,2478),set(825,141),get(598),set(828,1589),
	 * get(541),set(9,81),get(247),set(1140,2837),set(253,334),set(439,2621),get
	 * (556),set(1334,267),set(1319,1542),get(515),set(471,608),set(1286,3109),
	 * get(502),set(237,1521),set(358,1386),get(677),get(587),set(1110,879),set(
	 * 906,2252),get(525),set(1264,1883),set(1007,2628),set(717,526),get(587),
	 * set(949,1892),get(568),set(405,3189),get(773),get(706),set(731,3216),set(
	 * 531,221),set(1418,173),set(1052,3086),set(359,1804),set(1298,1778),set(
	 * 228,1118),set(307,430),set(370,2248),get(1338),set(169,1623),get(1255),
	 * get(160),set(467,2936),set(777,939),set(104,1094),get(760),set(478,17),
	 * get(1029),get(869),get(755),set(219,2881),set(1102,2880),set(532,759),get
	 * (70),set(170,505),get(1184),set(547,1392),set(1182,1094),set(1224,1169),
	 * set(102,2437),get(685),set(610,2581),get(122),get(970),set(616,672),set(
	 * 124,2480),set(777,2130),get(824),get(789),set(796,523),get(1429),get(1250
	 * ),set(741,1365),set(164,1674),set(875,2216),get(1176),set(361,666),get(
	 * 1006),get(618),get(1350),set(168,2118),set(1138,362),set(252,1215),set(
	 * 732,2937),get(50),set(778,823),get(798),set(294,3300),set(996,2245),get(
	 * 140),get(733),set(847,2194),set(146,1225),get(1415),set(993,1827),set(
	 * 1164,1441),get(1036),set(124,1021),set(535,1018),get(517),set(736,2307),
	 * set(897,2650),get(272),get(601),get(666),get(1181),get(1232),set(816,880)
	 * ,set(372,2306),set(1099,454),set(514,2900),get(1321),set(163,337),set(787
	 * ,2340),set(729,1818),set(1045,1161),set(443,2606),get(650),get(1146),set(
	 * 1133,1362),get(1169),get(1369),get(938),set(896,404),set(1142,1817),set(
	 * 124,3226),set(350,2027),get(591),set(1130,495),get(903),get(355),get(1180
	 * ),set(1209,2065),set(843,1854),set(929,1810),set(157,2356),get(1126),set(
	 * 415,3072),set(357,2036),set(605,2182),get(738),set(1421,2048),set(439,
	 * 1467),set(80,2073),set(1222,3209),set(479,3182),get(1019),set(103,264),
	 * get(730),set(320,1978),set(224,1087),get(24),get(1224),set(583,388),set(
	 * 1263,1675),get(1306),set(1173,2174),set(647,1078),set(911,885),get(539),
	 * get(522),get(737),set(537,732),get(504),get(1142),get(961),set(53,1885),
	 * set(250,1232),get(1044),set(592,3297),get(351),set(1136,2418),set(736,
	 * 1160),set(1174,3065),set(497,1674),get(930),set(696,3001),get(852),set(
	 * 1246,1794),get(392),set(837,1522),set(1165,3092),get(789),set(987,1671),
	 * get(934),set(1304,799),get(75),get(935),set(562,2547),set(1423,901),set(
	 * 890,3063),set(1111,301),set(1100,2368),get(1017),set(1193,3102),set(490,
	 * 1082),get(826),get(1276),set(163,1351),set(1039,1331),set(518,1653),set(
	 * 938,2332),set(780,1950),get(1279),get(714),get(1409),get(1226),set(769,
	 * 2116),set(986,2280),get(1012),set(694,2338),get(142),set(767,1919),set(
	 * 1353,1528),get(6),set(1280,1212),get(463),set(14,2154),set(256,1481),set(
	 * 955,377),get(1141),set(1,2101),set(54,15),set(1263,1725),set(35,2976),get
	 * (838),set(349,1512),get(146),set(452,419),get(457),set(268,1407),set(853,
	 * 1260),get(1378),set(1290,1511),set(895,1831),get(659),set(1097,1652),set(
	 * 559,2844),get(416),get(847),set(892,2093),set(108,536),get(1393),get(1341
	 * ),get(961),set(1354,3274),set(292,691),set(1165,302),get(1052),set(1270,
	 * 738),set(619,2515),get(1327),set(11,2877),set(452,2211),set(763,399),get(
	 * 393),get(1298),get(140),set(1202,210),set(1015,392),get(1281),get(121),
	 * set(207,1018),set(703,1947),set(555,2997),set(994,1879),get(564),get(26),
	 * get(1362),get(1125),get(216),set(547,1966),set(655,1400),get(749),set(870
	 * ,2761),get(886),set(1140,346),get(966),set(785,2694),set(313,1510),set(
	 * 779,2079),set(901,782),set(575,473),get(249),get(1047),get(276),get(797),
	 * set(1253,2585),set(23,604),set(5,1810),set(1115,863),set(42,1296),set(807
	 * ,3151),get(280),set(112,2313),get(37),set(1047,2363),set(431,2),get(986),
	 * get(1342),get(855),get(810),get(606),get(1137),get(1204),set(493,1537),
	 * set(313,2813),set(86,1868),set(632,787),get(907),set(546,3296),set(663,
	 * 1308),set(339,420),set(50,866),set(1273,815),get(1306),get(1061),set(1079
	 * ,2366),set(299,1650),set(649,1886),get(835),set(415,202),get(2),get(1156)
	 * ,set(680,1300),get(810),set(35,2356),set(608,3144),set(910,3206),get(261)
	 * ,get(219),set(665,1108),set(1320,230),set(979,66),set(1230,2910),set(1047
	 * ,1686),get(46),get(1303),get(374),set(641,3115),get(367),get(105),get(137
	 * ),set(197,3258),set(1080,983),set(787,1508),set(1115,2069),set(1320,1665)
	 * ,get(239),set(1104,1843),get(30),get(527),set(1188,2637),get(1023),get(
	 * 843),get(978),set(68,1847),set(517,460),set(351,1432),set(561,2162),set(
	 * 214,3183),get(1330),get(1256),set(1173,2967),set(148,2072),get(550),set(
	 * 329,688),set(1192,3177),get(535),get(584),get(200),get(271),set(1317,63),
	 * set(1218,1393),set(946,2429),set(57,2218),set(814,793),get(1035),get(909)
	 * ,set(1128,1),set(1144,1205),set(855,1860),get(1082),set(1025,1717),get(
	 * 569),get(988),get(50),set(68,524),get(506),get(727),set(1033,2407),get(
	 * 1048),set(1246,246),get(1306),get(577),get(890),get(756),set(741,11),set(
	 * 691,3260),set(987,2169),get(91),get(1191),set(1082,575),get(431),set(1048
	 * ,3267),set(320,834),get(896),set(1351,1299),get(184),get(977),set(146,
	 * 1927),set(413,177),set(1087,1758),get(217),get(632),set(1225,1627),get(
	 * 1180),set(504,1619),get(754),get(1000),set(316,3062),get(167),get(464),
	 * set(1242,2052),set(614,1750),set(675,2658),set(23,881),get(1105),set(1428
	 * ,2755),set(12,905),get(1349),set(383,931),get(1216),get(652),set(260,1596
	 * ),get(191),get(1143),get(1135),set(948,2586),set(240,1092),set(733,2954),
	 * get(1260),set(565,625),get(399),get(1098),get(393),get(817),set(1100,1686
	 * ),set(1333,1394),get(41),set(1395,2275),set(425,1151),set(788,2921),set(
	 * 925,1440),set(475,958),get(259),set(811,868),set(132,1535),get(989),set(
	 * 1013,1239),get(411),set(1359,670),set(1283,794),set(894,102),set(1268,
	 * 2406),set(1050,3060),set(172,2765),set(1274,1591),get(45),set(707,2542),
	 * set(987,1903),set(1398,3020),get(1427),get(1026),set(317,1606),set(385,
	 * 2076),get(970),set(733,1842),set(1076,2322),set(988,2464),get(1282),get(
	 * 66),get(1106),get(668),get(634),get(647),set(493,650),set(526,1241),set(
	 * 255,3137),get(661),set(1207,377),set(556,1200),set(963,18),set(1309,446),
	 * set(1362,1713),get(729),set(991,3110),set(1020,1666),set(854,2361),get(
	 * 1271),set(1365,2836),get(845),set(1334,2475),get(1037),set(1186,3064),set
	 * (235,1121),set(406,3293),set(381,1219),get(942),set(139,3241),set(1139,
	 * 1616),set(708,2970),get(1366),set(515,1823),get(894),get(185),set(927,
	 * 3173),set(823,736),set(1130,1395),set(377,618),set(252,2461),get(190),get
	 * (1125),set(8,320),set(107,1948),set(340,277),get(1158),get(1289),get(1044
	 * ),get(797),get(351),get(1161),get(1152),get(35),get(249),get(671),get(946
	 * ),get(1180),get(742),get(524),set(44,3090),get(1045),set(1186,2991),get(
	 * 1314),set(795,2668),set(994,154),set(583,217),set(513,885),set(877,1779),
	 * set(397,1024),set(159,3230),get(1036),set(863,2457),set(459,610),get(1238
	 * ),set(1049,1685),get(687),set(1364,1252),get(543),get(149),get(1118),get(
	 * 1199),get(602),set(259,106),set(441,52),get(445),set(32,3143),get(942),
	 * set(692,2873),set(449,1204),get(793),set(896,803),set(215,3121),get(922),
	 * set(91,18),get(791),get(1357),get(859),set(1051,2996),set(480,1885),set(
	 * 1428,1386),get(1108),set(1400,2985),set(396,1140),set(1374,214),set(874,6
	 * ),get(1400),set(171,1509),set(1008,1988),get(1248),set(541,708),get(953),
	 * set(1011,2592),get(1222),set(384,496),get(32),get(921),set(1328,2483),get
	 * (782),set(701,2722),set(1335,1489),get(377),set(498,931),set(1398,2085),
	 * get(1153),set(139,317),get(151),set(1113,1599),get(460),set(324,1131),set
	 * (772,1074),set(323,1413),get(82),get(134),set(495,181),set(437,1232),set(
	 * 1156,1882),get(843),set(527,291),get(415),set(1337,885),set(245,231),set(
	 * 342,2294),get(807),get(290),set(185,1845),get(216),set(887,1466),set(1329
	 * ,274),get(394),get(1037),get(1217),set(1249,3188),set(424,3261),set(959,
	 * 746),set(684,3121),set(515,2970),set(203,2397),get(450),get(160),set(23,
	 * 1515),get(1163),get(957),get(932),set(512,1025),get(528),set(829,3289),
	 * get(1372),set(188,422),set(383,2436),get(260),set(261,2057),set(396,3139)
	 * ,set(1030,486),get(615),set(479,153),set(1395,377),set(249,1734),set(1354
	 * ,2061),set(1364,187),set(803,2364),set(1415,1737),set(1354,1535),set(1274
	 * ,1873),get(656),get(814),set(150,2004),get(1389),set(1063,1685),get(1393)
	 * ,set(517,2841),set(1047,1681),set(1192,621),set(1078,2014),get(620),get(
	 * 1143),set(876,1854),set(1253,1202),set(961,2758),set(233,2385),get(80),
	 * get(503),set(1309,3259),set(915,159),set(991,3145),get(1247),set(163,1845
	 * ),set(1035,1141),get(1216),set(1048,1888),set(693,2886),set(9,2427),set(
	 * 971,1971),get(168),set(952,1841),get(1307),set(948,2001),get(1412),set(
	 * 709,2572),set(546,1757),get(673),set(688,1585),set(316,714),get(740),set(
	 * 312,424),get(396),get(1329),set(41,2303),set(721,171),set(1355,2535),get(
	 * 906),get(959),set(111,1101),get(1015),set(826,3131),get(821),get(1386),
	 * set(1358,867),set(197,729),get(747),set(251,3071),set(1231,3107),set(1381
	 * ,2098),set(547,1323),get(1429),set(706,3036),set(1121,528),set(1348,1315)
	 * ,get(283),set(535,2447),set(1422,100),set(540,599),get(549),get(10),set(
	 * 1349,813),get(1392),set(317,777),get(698),get(208),get(1356),set(1260,
	 * 2838),get(1319),set(232,1348),get(488),get(955),set(263,3228),get(163),
	 * get(1376),set(519,2698),get(1269),get(1027),get(115),set(285,2799),set(
	 * 1388,2614),get(978),set(366,865),set(949,1137),get(976),get(260),get(290)
	 * ,set(607,2504),set(355,1038),get(452),set(1151,1535),set(70,170),set(258,
	 * 2910),get(972),set(143,2159),get(1228),set(776,3024),set(35,2975),get(564
	 * ),set(931,1219),get(1293),set(1109,3149),get(1314),set(386,1251),set(1401
	 * ,284),get(65),set(1170,2003),get(740),set(1124,2579),set(945,2418),set(
	 * 831,1604),set(1308,1470),set(119,2467),set(1167,240),set(821,2523),get(
	 * 340),set(378,1805),set(1126,50),get(168),get(1209),get(895),get(7),set(
	 * 1401,710),set(869,695),set(237,2521),set(355,3166),get(1240),set(204,374)
	 * ,set(48,1682),get(498),set(129,2931),get(661),get(525),set(438,2071),set(
	 * 290,2685),get(1228),set(170,2860),get(74),set(1220,3094),set(653,1280),
	 * get(1089),set(1264,2961),set(791,1552),get(1121),set(399,2065),set(917,32
	 * ),get(270),get(307),get(1108),set(1075,1792),get(556),set(545,1489),set(
	 * 107,3141),set(1411,2535),set(1173,1665),set(998,13),get(494),get(866),set
	 * (825,455),get(629),set(398,1961),set(1260,2915),set(532,1781),set(975,
	 * 2857),set(587,88),set(1017,1676),set(1327,88),get(457),set(659,3157),get(
	 * 1252),set(1199,480),set(308,2839),get(40),get(523),get(357),set(543,2696)
	 * ,set(771,1282),get(664),set(593,1000),set(463,3103),set(1086,194),set(
	 * 1429,2558),set(131,1296),set(64,758),set(1023,2754),set(548,3081),set(
	 * 1175,199),get(201),set(309,1110),get(1185),get(1022),get(663),get(100),
	 * get(38),set(694,2790),get(127),set(1245,1116),get(579),set(47,2432),set(
	 * 77,3091),set(1100,1264),set(1156,2222),set(1147,1550),set(1403,563),get(
	 * 608),get(236),set(240,821),get(1043),get(595),set(633,3210),get(49),set(
	 * 127,2169),set(1287,3223),set(998,221),set(1140,2447),set(1138,174),get(
	 * 196),get(1105),set(199,1640),set(105,1430),set(514,2123),get(771),set(672
	 * ,1513),set(1326,2497),set(570,512),set(1376,273),set(325,599),set(464,589
	 * ),get(566),set(481,531),get(34),get(1274),get(186),get(721),get(994),get(
	 * 417),get(162),get(623),get(547),get(75),get(1079),get(1274),get(92),get(
	 * 255),set(208,256),set(1054,1798),set(810,1282),set(57,2718),set(683,2524)
	 * ,get(5),set(226,2631),set(476,927),set(796,2290),set(284,2799),get(739),
	 * set(649,3156),set(1191,2220),set(70,1096),set(1296,265),set(1094,2616),
	 * set(249,1004),get(1351),get(1057),set(335,1027),get(1038),set(448,2358),
	 * set(506,33),set(1033,2553),set(126,2968),set(1142,2145),set(872,2270),set
	 * (1315,2235),set(403,2670),set(1200,1467),set(709,2572),get(267),get(628),
	 * set(505,3221),set(990,294),get(43),set(1193,48),set(38,1006),set(1221,
	 * 1458),set(646,1379),set(523,1182),set(1125,1342),get(168),get(903),get(
	 * 316),set(653,2276),set(92,490),set(787,349),set(111,2037),set(873,523),
	 * set(1409,1633),get(597),set(1340,1783),set(926,1784),set(480,1914),set(
	 * 1251,1244),get(975),get(772),get(319),set(1286,1177),get(385),get(933),
	 * get(693),get(318),set(32,1270),get(1415),get(53),get(419),set(1123,2594),
	 * get(192),get(525),get(1358),set(377,2921),set(1187,236),get(104),set(684,
	 * 2968),get(716),set(724,3113),set(293,1600),get(858),get(529),get(1096),
	 * get(328),set(1290,2030),set(1002,2971),get(821),set(533,996),set(1240,
	 * 1702),get(387),set(371,2281),get(736),get(516),set(1351,785),set(520,2416
	 * ),set(597,2170),set(1203,2922),set(591,1680),get(1200),get(1032),set(39,
	 * 3111),set(127,963),get(567),set(1079,2405),get(146),set(449,1115),set(321
	 * ,300),get(731),set(109,726),get(1288),get(1122),set(1044,1911),get(395),
	 * set(196,1207),set(1100,613),get(727),set(257,1433),set(86,1667),set(259,
	 * 2962),get(258),set(180,3169),set(1283,2721),get(37),get(1066),set(890,
	 * 2643),get(1122),set(762,192),get(160),get(343),get(968),get(488),get(523)
	 * ,get(1387),get(1128),set(897,40),set(575,261),get(1274),set(1356,646),set
	 * (156,2855),set(964,1089),get(601),set(1004,2888),get(1156),set(1069,3179)
	 * ,set(11,1252),set(196,1659),get(165),set(192,2261),get(510),get(187),set(
	 * 504,1865),set(1292,2934),set(895,3026),get(1000),set(858,1707),set(895,
	 * 2218),set(551,1305),set(365,2743),set(686,1748),get(400),set(997,1533),
	 * set(1275,1536),get(635),set(1122,3190),set(611,726),set(1147,591),set(506
	 * ,2739),set(373,2292),set(665,610),get(805),get(919),set(383,3222),get(493
	 * ),set(1066,1128),set(759,207),set(883,828),get(285),get(832),set(342,1212
	 * ),get(614),get(186),set(1254,606),set(15,1248),get(1001),set(993,1724),
	 * set(53,2363),get(246),get(1207),get(1317),set(234,3229),set(993,1186),set
	 * (1054,870),set(1056,3140),get(736),get(131),set(971,131),set(488,243),set
	 * (274,2288),get(809),set(1269,1858),set(473,3029),set(357,2041),set(192,35
	 * ),set(1193,537),set(905,3163),get(1334),set(172,136),set(707,2254),get(
	 * 1172),get(1040),get(83),set(1009,1522),get(1220),set(117,1034),set(87,755
	 * ),get(1232),set(461,2660),get(817),get(564),get(1055),get(1241),set(1296,
	 * 1532),get(1231),set(826,2970),get(988),get(568),set(1273,2370),set(31,
	 * 2494),set(47,2394),get(120),set(841,2083),get(589),set(133,3054),set(824,
	 * 56),set(483,730),get(370),set(1042,2784),set(294,1195),get(1257),set(1227
	 * ,1589),get(96),set(1370,626),set(356,91),get(1419),get(1131),get(888),set
	 * (408,726),set(1361,1336),set(545,1728),set(470,2493),set(723,2592),set(
	 * 980,1577),set(234,2179),set(343,2413),set(1168,1273),set(1240,1736),get(
	 * 111),get(254),get(868),set(1327,877),set(104,2780),get(1227),get(851),set
	 * (1254,2986),set(846,2380),get(811),get(525),get(1149),set(1029,2540),set(
	 * 1198,879),set(227,2054),get(1065),get(392),get(780),get(406),set(1365,
	 * 1588),set(1379,545),set(907,3044),set(241,1641),get(491),get(1172),set(
	 * 236,248),get(154),set(1396,902),get(998),set(974,2920),set(591,2595),get(
	 * 320),set(1076,2989),set(654,591),set(998,1330),set(808,1879),set(751,1382
	 * ),set(749,554),set(321,3247),set(954,995),get(225),set(1359,1314),get(235
	 * ),get(525),get(1208),get(343),set(819,87),set(737,2262),set(595,2913),set
	 * (711,1527),set(707,2659),get(549),get(605),set(434,2280),set(553,1420),
	 * get(1410),set(1060,1275),set(221,1446),set(1287,2627),set(44,2952),get(
	 * 916),set(98,827),get(1035),set(274,36),get(58),get(586),set(91,2455),set(
	 * 831,1172),set(129,3065),get(1257),get(1301),get(1422),get(1122),get(593),
	 * set(1165,329),get(469),set(1277,2956),set(63,1801),get(281),get(1032),set
	 * (175,2830),get(123),get(1400),set(1406,830),set(179,2674),set(137,2288),
	 * set(1177,790),get(369),set(282,1730),set(464,627),get(658),set(1059,983),
	 * set(100,1172),set(640,3298),set(1113,1764),set(140,2053),get(1329),get(
	 * 1297),get(46),set(536,410),set(598,492),get(1302),get(286),set(224,920),
	 * set(778,1072),set(494,2098),set(863,2309),set(872,225),set(146,904),get(
	 * 344),get(288),get(418),set(802,282),get(65),get(677),set(382,20),get(226)
	 * ,set(169,2672),set(683,1278),get(1246),set(1165,3074),set(676,1759),get(
	 * 1143),get(486),get(391),get(1101),get(1340),get(1422),set(768,278),set(
	 * 511,2753),set(1367,2554),get(349),set(278,2418),set(2,219),set(842,790),
	 * get(668),set(467,2127),get(735),set(935,150),set(1183,1917),set(1397,2319
	 * ),get(611),set(373,2897),set(632,1481),get(1343),set(955,1086),set(834,
	 * 1350),get(181),get(1239),set(326,1227),set(1264,893),set(165,767),get(
	 * 1378),set(1172,1177),get(916),get(581),get(802),set(123,1505),get(103),
	 * get(1175),set(550,2808),get(220),get(629),get(203),get(26),get(862),set(
	 * 1118,570),set(295,1203),set(1088,2992),set(689,384),set(566,2611),get(
	 * 1140),get(686),get(409),set(123,959),set(470,1391),set(820,2107),get(709)
	 * ,get(1039),get(808),set(930,887),set(893,2144),set(904,2311),set(280,482)
	 * ,get(294),get(1170),get(1232),get(845),set(689,2681),set(815,2442),get(
	 * 133),get(240),get(1332),get(337),set(132,1938),set(716,2644),get(1379),
	 * set(48,355),get(404),get(341),get(806),set(1085,2520),get(578),get(167),
	 * get(468),set(1415,2719),set(259,365),set(317,1078),set(584,571),get(995),
	 * set(528,2085),get(1110),set(60,1696),get(286),set(392,450),set(593,1222),
	 * set(821,1400),get(27),set(434,1481),set(433,1676),set(871,189),set(568,
	 * 2228),get(123),set(998,396),get(609),set(548,612),set(854,2301),get(872),
	 * set(247,2710),set(979,2850),set(1033,355),get(305),get(310),set(167,998),
	 * set(1338,1998),set(825,2480),set(1095,388),set(41,1678),set(973,1904),get
	 * (710),set(252,2667),set(277,3210),get(150),set(1179,911),get(773),get(
	 * 1361),get(598),get(886),set(800,688),set(655,667),set(413,1650),set(1429,
	 * 464),get(1215),set(393,700),get(563),set(659,3031),get(744),set(587,1397)
	 * ,set(398,1392),set(75,1856),set(135,915),get(928),get(992),set(733,760),
	 * set(666,1464),set(379,714),set(128,415),get(1151),set(138,1125),get(1219)
	 * ,set(1170,1882),set(993,2094),set(979,1076),set(635,1092),set(7,296),set(
	 * 578,1863),set(699,973),set(364,406),set(858,3020),get(1029),set(864,439),
	 * get(494),get(552),set(666,2373),set(513,430),set(984,1222),set(1101,2155)
	 * ,get(113),get(954),get(993),set(1177,1462),set(293,2403),set(789,2261),
	 * set(1090,891),set(1336,1577),set(1318,2310),set(493,2141),get(464),get(
	 * 408),get(1384),set(27,697),set(145,625),set(991,2015),get(48),set(387,
	 * 1847),get(1409),set(409,1834),set(1342,2129),get(436),set(1214,2824),set(
	 * 1274,2219),set(830,12),get(293),set(418,557),set(1176,2587),get(941),set(
	 * 818,1888),get(1427),get(1350),get(430),set(452,3220),get(990),get(1340),
	 * set(497,1665),get(373),set(558,2724),set(1027,1854),get(11),set(1013,875)
	 * ,set(701,2190),set(196,2727),set(1344,298),get(495),get(1162),set(300,
	 * 1137),set(627,3213),set(275,1705),set(292,1612),set(474,2669),get(1027),
	 * set(46,3062),set(556,3124),get(1370),set(1341,1529),get(516),get(444),get
	 * (1249),get(500),get(476),get(447),set(513,848),set(504,2189),get(986),set
	 * (1037,1545),set(1235,1412),set(316,1594),set(664,2731),get(1260),get(505)
	 * ,set(1152,1131),set(892,2890),set(959,1416),get(636),get(258),get(1057),
	 * get(578),get(442),get(844),get(62),get(1339),get(1223),set(852,1837),set(
	 * 1037,3014),get(1002),set(147,303),set(1355,2689),get(255),set(1217,3281),
	 * set(254,139),set(1064,862),get(685),get(581),set(94,2602),get(694),set(98
	 * ,1651),set(657,1229),set(383,3170),get(1193),get(694),set(517,1963),get(
	 * 492),get(158),get(925),set(1055,2986),get(1385),set(714,2869),get(352),
	 * get(481),set(499,3109),set(359,766),get(59),get(1063),set(77,2891),get(
	 * 961),set(1293,357),set(1074,630),set(216,1552),set(734,2828),get(317),get
	 * (181),set(643,1552),get(543),get(565),get(1405),get(1317),set(294,655),
	 * set(1292,2128),get(73),get(95),get(226),set(1408,2098),set(1351,1860),set
	 * (776,1716),set(335,1608),get(411),get(560),set(120,2127),set(740,2218),
	 * get(515),set(484,2609),get(798),get(314),get(276),set(1209,936),set(883,
	 * 523),get(241),get(1181),get(763),get(644),set(136,2490),get(1365),get(932
	 * ),set(44,1315),set(871,1645),set(1099,1859),set(1125,1958),set(238,330),
	 * get(898),get(25),set(463,1187),set(1391,2461),set(1226,3264),set(1404,
	 * 1753),set(1065,1272),set(910,960),set(288,2700),get(456),get(713),set(
	 * 1358,2395),get(1183),get(460),get(1305),set(996,1568),set(943,1287),set(
	 * 606,630),set(1175,2530),get(1148),get(1067),set(393,1836),get(193),set(
	 * 1177,2885),get(1173),set(644,2750),get(82),get(179),get(1290),get(559),
	 * set(900,392),get(1306),set(91,2998),get(693),set(910,2515),set(280,2254),
	 * set(702,2909),get(145),set(922,2660),get(1188),set(97,2426),get(960),set(
	 * 822,2188),set(356,644),get(103),get(791),get(849),set(994,842),set(471,
	 * 2033),get(284),set(195,614),get(928),get(96),set(1230,2256),get(237),set(
	 * 1104,2111),get(1317),set(609,1456),set(1155,2852),set(709,2272),set(658,
	 * 2367),set(322,386),set(458,2758),set(173,3246),set(666,555),get(350),set(
	 * 1369,797),set(1326,1422),set(715,3160),get(370),set(574,1727),set(728,
	 * 1203),get(60),set(1193,1295),set(994,2857),set(190,380),set(1420,2840),
	 * get(1300),get(859),set(414,2540),get(387),get(1278),set(972,1341),set(906
	 * ,2525),get(719),get(172),get(341),get(652),get(1276),get(819),get(1098),
	 * set(1326,741),set(622,2807),get(1032),set(474,2986),get(328),get(137),get
	 * (917),set(612,2231),get(615),get(478),get(1029),get(244),get(808),get(914
	 * ),get(488),set(492,63),get(288),set(1163,623),set(1303,1269),get(192),set
	 * (815,533),set(244,2258),get(1019),get(1209),get(1183),get(808),set(1191,
	 * 2545),set(1174,2749),set(100,776),set(1144,191),get(1024),set(557,1174),
	 * get(394),get(552),set(295,3074),set(667,603),set(1264,171),set(1257,1615)
	 * ,get(743),set(523,1829),set(1356,2018),get(1219),set(962,2786),set(1174,
	 * 2247),set(1430,308),get(863),set(601,3011),get(652),set(698,1314),get(935
	 * ),set(893,1834),set(1063,1090),set(530,619),set(167,997),set(1420,1871),
	 * get(1017),get(951),get(900),set(1373,1100),get(695),set(94,2079),set(1238
	 * ,2977),get(1023),set(1304,1350),set(1123,346),set(1062,902),set(1012,994)
	 * ,get(1424),get(14),set(274,3289),set(202,3074),set(1166,1363),set(321,
	 * 3284),get(185),set(322,480),get(223),get(397),set(1012,2312),get(144),set
	 * (1128,1231),get(805),get(31),set(822,2282),set(1137,659),set(1223,2991),
	 * get(1301),set(1367,2461),set(274,1022),set(504,2331),get(1104),set(366,
	 * 2960),set(701,541),set(169,1117),set(642,824),set(1320,1354),get(471),get
	 * (1121),get(1369),get(535),get(1291),set(1415,2358),set(1049,360),get(1188
	 * ),get(639),set(702,2605),get(1069),get(799),set(967,3269),set(966,2077),
	 * get(1189),set(436,1399),get(1170),set(1010,1170),get(467),set(1409,1027),
	 * get(931),get(547),set(1159,1333),get(644),set(971,2634),set(774,1054),set
	 * (1388,212),set(1106,2492),get(1365),set(872,406),get(599),set(1409,2188),
	 * set(518,2139),set(362,549),get(539),set(832,501),set(320,2488),set(314,
	 * 2544),set(737,174),get(828),get(181),set(823,1784),set(467,357),set(764,
	 * 162),set(400,1497),get(1389),set(394,1510),set(763,1028),set(854,3221),
	 * get(1312),get(907),set(1067,2569),get(347),get(485),get(863),get(1162),
	 * set(1,2070),set(792,3170),set(1223,1872),set(1257,679),set(1234,3194),set
	 * (968,1313),set(303,1496),get(778),set(1215,1757),set(382,1155),set(1221,
	 * 737),set(1159,767),set(992,829),get(434),set(1233,2510),set(425,1899),get
	 * (391),get(63),get(1154),get(1134),set(1143,1939),get(400),get(711),get(68
	 * ),get(1015),set(589,1669),get(411),set(181,1011),set(781,2580),set(531,
	 * 121),set(695,620),set(471,2817),get(504),get(142),get(1280),set(1273,2288
	 * ),get(504),get(359),get(271),set(845,2010),get(1268),set(373,2948),get(
	 * 1288),get(1276),set(597,2802),set(654,245),set(1335,598),get(418),get(368
	 * ),set(944,2670),set(1169,250),get(792),set(131,2126),set(707,1783),get(
	 * 560),get(283),get(141),get(1202),get(1097),get(337),get(702),set(874,801)
	 * ,set(809,114),get(889),get(165),set(1295,1137),set(344,1733),get(630),get
	 * (867),get(246),set(444,147),set(1077,1887),set(583,909),set(750,1997),set
	 * (1299,2763),get(1174),get(989),set(897,1417),set(452,2834),set(90,2727),
	 * get(464),set(1103,2037),set(352,2783),get(154),set(144,2465),get(318),get
	 * (315),set(966,2765),set(1311,3227),get(151),set(76,1083),get(1384),get(
	 * 129),set(1087,742),get(472),get(853),set(236,202),set(178,149),set(746,
	 * 113),set(243,2443),get(1336),get(1),get(530),get(1415),get(363),set(1144,
	 * 2954),get(184),get(1003),set(384,1764),get(482),set(735,487),get(675),get
	 * (6),set(159,1890),get(1),get(56),get(1059),get(1148),get(606),set(794,
	 * 1509),get(1422),get(151),set(585,2141),set(1240,2748),set(336,3197),set(
	 * 92,185),set(475,232),get(1415),set(761,1804),set(319,367),get(901),set(
	 * 1059,2668),set(274,2592),set(972,2403),set(622,1310),set(742,1084),set(
	 * 419,2213),set(253,2693),set(802,2437),set(1358,1567),set(649,2881),set(
	 * 474,918),set(1006,496),set(1073,1548),get(750),set(607,2549),get(1360),
	 * get(516),get(520),get(1390),set(1258,3179),set(1004,1131),set(971,1761),
	 * set(491,561),get(239),set(125,525),get(56),set(1000,73),get(1230),set(11,
	 * 2518),set(826,3),set(374,1288),set(248,2482),set(708,1107),set(145,400),
	 * get(425),set(1238,503),set(1154,2481),get(996),get(439),set(1411,757),get
	 * (1167),set(333,1898),set(236,866),set(11,2949),set(1036,158),set(551,2100
	 * ),set(106,675),get(33),get(199),set(825,1870),set(153,1037),set(767,1634)
	 * ,get(871),set(444,677),get(1281),set(1387,1463),set(707,993),set(990,28),
	 * set(483,1981),set(673,2786),set(209,1784),get(1273),get(45),get(757),set(
	 * 1309,1917),set(176,1859),set(1183,1222),get(82),get(422),get(668),get(
	 * 1351),set(306,2099),set(1346,719),set(888,73),set(1144,3172),set(70,2153)
	 * ,get(54),set(65,995),set(1067,2294),set(361,72),set(1093,2817),get(1291),
	 * set(1368,2398),set(1079,1458),get(1151),set(871,1656),set(485,2725),get(
	 * 596),get(363),set(1207,2820),get(525),set(1331,2129),get(563),set(734,716
	 * ),get(707),get(792),set(1237,2305),get(1182),get(214),set(331,3137),get(
	 * 66),get(1211),set(1091,219),set(1105,1126),set(465,1523),get(617),get(888
	 * ),set(1231,1500),set(217,250),get(202),get(83),set(1090,2738),get(767),
	 * set(910,2385),set(1052,1815),set(26,1515),set(236,1277),set(192,1661),get
	 * (273),set(424,1404),set(947,255),set(551,2356),set(447,1348),get(403),set
	 * (42,1404),get(799),set(270,2876),set(569,1250),get(866),get(574),get(933)
	 * ,get(361),get(775),get(1408),set(741,1104),get(412),get(415),set(736,2771
	 * ),set(54,870),get(165),get(451),get(864),set(197,656),get(215),set(650,
	 * 1174),set(275,2987),set(168,768),set(1205,627),get(172),get(1154),get(710
	 * ),set(485,597),get(1412),get(99),set(176,2755),get(1368),get(1347),set(88
	 * ,2182),set(306,553),set(582,647),set(572,2904),set(729,2),get(172),get(
	 * 732),set(138,171),set(1353,1665),set(393,1005),set(140,2849),set(1176,
	 * 3144),set(1236,1031),set(177,430),set(254,2963),set(202,1196),get(876),
	 * get(620),set(1345,2485),set(360,1033),set(734,1714),get(736),set(555,343)
	 * ,set(62,1028),set(1079,1636),get(1028),get(271),set(586,2055),get(791),
	 * set(1041,3276),get(713),set(47,963),set(202,720),set(355,1416),set(246,
	 * 2900),get(1256),get(1103),set(626,598),set(779,1541),set(1376,2142),get(
	 * 222),set(186,1714),get(515),get(359),get(921),set(285,1595),get(786),get(
	 * 461),set(226,2043),get(941),set(525,2759),get(110),set(117,1840),get(1018
	 * ),set(997,492),set(885,594),set(1004,147),set(464,1426),set(15,143),get(
	 * 1179),set(14,663),set(386,846),get(14),set(566,1772),get(133),get(1226),
	 * set(1189,1528),set(296,1164),set(1401,292),set(223,1331),get(1427),set(
	 * 542,2472),get(1367),get(31),get(482),set(128,1235),get(258),get(160),set(
	 * 1060,2329),get(1008),set(1305,3018),set(960,1355),set(1396,2700),set(1330
	 * ,509),set(403,2039),get(946),set(712,656),set(1255,3040),set(87,3124),set
	 * (124,1331),set(916,167),set(1036,433),set(875,2110),get(664),get(526),get
	 * (792),set(87,2959),set(948,2518),set(1041,851),get(91),get(7),set(320,151
	 * ),get(1234),set(649,220),set(96,2075),set(1080,390),set(1113,3203),set(
	 * 1108,958),set(1226,1807),set(813,935),set(950,2851),get(1351),set(1053,
	 * 613),set(722,1525),get(1379),set(77,374),get(606),set(9,1613),set(903,
	 * 2445),get(727),get(598),get(1265),set(908,3235),get(256),set(1210,2411),
	 * get(609),set(289,2083),set(11,1297),set(474,524),set(438,3075),set(1419,
	 * 1691),set(954,1896),get(953),set(1123,283),get(760),get(47),set(336,2304)
	 * ,set(337,1141),get(133),get(748),set(1298,2620),set(1032,2157),get(1368),
	 * set(930,2453),set(1027,1465),set(1049,2142),get(507),get(20),get(453),set
	 * (1198,2038),set(672,1776),get(907),get(728),set(945,2938),set(1346,1131),
	 * get(1227),set(547,1001),get(15),get(1271),get(1149),set(36,1507),set(231,
	 * 1125),get(181),set(1131,2956),get(516),set(766,1750),set(1159,475),get(
	 * 689),get(339),get(372),set(726,3027),set(155,1393),get(113),set(691,3278)
	 * ,get(69),set(1130,1165),set(1223,738),set(669,2141),set(1326,1467),set(
	 * 940,1015),set(775,1347),set(1193,1617),set(476,1441),get(574),get(1399),
	 * set(514,2962),set(362,2285),set(1162,470),get(1362),set(1078,1782),get(
	 * 942),get(766),get(252),set(877,2760),set(1287,1133),get(851),set(1211,
	 * 1150),set(373,2031),set(1291,1228),get(6),set(494,369),get(1215),get(634)
	 * ,set(33,2759),set(1046,1833),set(1036,1389),set(1179,429),set(307,3231),
	 * get(584),get(348),get(223),get(1070),get(1396),set(1305,2213),set(512,380
	 * ),get(545),get(369),set(1323,2988),set(1057,748),set(838,2115),set(628,
	 * 3301),get(18),get(630),get(810),set(1362,3108),get(802),set(348,1111),get
	 * (1005),set(53,1050),set(762,3071),set(446,2426),set(1102,127),set(251,
	 * 2103),set(120,2267),set(1324,1796),set(1030,2298),get(867),set(1424,2524)
	 * ,get(36),set(1053,2774),set(66,870),set(1169,2054),set(711,1152),set(464,
	 * 673),get(904),get(913),set(788,2440),set(420,2869),set(153,1498),set(1103
	 * ,3117),set(299,1659),set(1026,2991),set(247,1783),get(613),get(1011),set(
	 * 197,1530),get(589),get(1421),get(500),set(1293,184),set(1178,1093),set(
	 * 491,468),get(521),get(638),get(1296),get(793),set(892,1923),set(354,1034)
	 * ,get(1142),set(1217,3126),get(1016),get(398),set(433,1143),set(1084,3178)
	 * ,set(60,2858),get(1426),set(952,2626),get(630),set(110,758),get(283),set(
	 * 57,1768),get(677),set(655,1744),set(512,2656),get(350),get(446),get(138),
	 * set(84,677),get(128),set(304,595),set(617,1316),get(510),get(580),get(748
	 * )]
	 * 
	 * Reason: System.out.println(); LRU Considering HashMap is fast enough, so
	 * I/O operation costs some time. Removed the System.out.println() and then
	 * everything was fine.
	 * 
	 * 
	 * 
	 * 
	 * Input: 2,[set(2,1),set(1,1),get(2),set(4,1),get(1),get(2)] Output:
	 * [1,1,-1] Expected: [1,-1,1]
	 * 
	 * 1,[set(2,1),get(2),set(3,2),get(2),get(3)]
	 * 
	 * 
	 * 
	 * Input: 2,[set(2,1),set(1,1),set(2,3),set(4,1),get(1),get(2)] Output:
	 * [1,-1] Expected: [-1,3]
	 * 
	 * 
	 * 
	 */

	// HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	//
	// int capacity = 0;
	//
	// // The real length of the LRUCache
	// int length = 0;
	//
	// Node head = null;
	// Node rear = null;
	//
	// public LRUCache(int capacity) {
	// this.capacity = capacity;
	// }
	//
	// public int get(int key) {
	//
	//
	// if (map.get(key) != null) {
	//
	// /*
	// * Very important:
	// *
	// * We need to delete the previous existing node
	// *
	// */
	//
	// Node tmpNode=map.get(key);
	//
	//
	// if(head!=rear&&rear==tmpNode) rear=tmpNode.prev;
	//
	// if(tmpNode.prev==null&tmpNode.next==null){ return map.get(key).value;}
	//
	// if(tmpNode.prev!=null){
	// tmpNode.prev.next=tmpNode.next;
	// }
	// if(tmpNode.next!=null){
	// tmpNode.next=tmpNode.prev;
	// }
	//
	//
	//
	//
	// setHead(map.get(key));
	// System.out.println("remove and set head:"+key+" "+map.get(key).value);
	// return map.get(key).value;
	//
	// // list.remove(map.get(key));
	// /*
	// * we cannot use it, as when we want to remove element, we cannot
	// * get the right position of that specific element. As LinkedList's
	// * remove method only will search the first found element and remove
	// * it.
	// */
	//
	// }
	// return -1;
	// }
	//
	// public void set(int key, int value) {
	// if (map.get(key) != null) {
	// Node tmp = map.get(key);
	// tmp.value = value;
	// setHead(tmp);
	// } else {
	//
	//
	//
	// /*
	// Wrong Answer More Details
	// Input:
	// 1,[set(2,1),get(2)]
	// Output:
	// [-1]
	// Expected:
	// [1]
	//
	// Reason: careless mistake. Need to add the new Node into the HashMap
	// *
	// *
	// */
	//
	//
	// Node newNode = new Node(key, value);
	//
	// map.put(key, newNode);
	//
	// if (length < capacity) {
	// setHead(newNode);
	//
	// // if the length > capacity, then remove the last one.
	// } else {
	// removeRear();
	// setHead(newNode);
	// }
	//
	// length++;
	// System.out.println("current:" + length + " " + capacity);
	// }
	// }
	//
	// public void setHead(Node node) {
	// /*
	// * Only two cases here: 1. head==null 2. head!=null
	// */
	//
	// if (head == null) {
	// head = node;
	// rear = head;
	// } else {
	//
	// //In case, there is only one node and then create the loop
	//// if(head==node) return;
	//
	// head.prev = node;
	// node.prev=null;
	// node.next = head;
	// head = node;
	// }
	//
	// }
	//
	// public void removeRear() {
	// /*
	// * 1. rear==null 2. rear!=null
	// *
	// */
	//
	// //do remember to clear HashMap for this rear's key.
	// if(rear!=null){
	// map.put(rear.key, null);
	// }
	//
	//
	// if (rear == null)
	// rear = head;
	// else {
	// rear = rear.prev;
	// if (rear == null) {
	// head = rear;
	// } else {
	// rear.next = null;
	// }
	// }
	//
	//
	//
	//
	// length--;
	//
	// }

	
	
	
//	
//	public void loopList() {
//
//		// In order to not modifiy the previous list
//		Node tmp = head;
//		System.out.println("loop list:");
//		while (tmp != null) {
//
//			System.out.println("Key:" + tmp.key + " Value:" + tmp.value);
//
//			tmp = tmp.next;
//
//		}
//		System.out.println("head:" + head.key + " end:" + rear.key);
//
//	}

}
