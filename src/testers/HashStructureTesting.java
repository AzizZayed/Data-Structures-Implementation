package testers;

import dataStructures.hashStructures.HashSet;
import dataStructures.hashStructures.HashStructure;
import dataStructures.hashStructures.HashTable;

public class HashStructureTesting {
	public static void main(String[] args) {
		testSet();
		testTable();
	}

	public static void print(HashStructure map) {
		System.out.print("\nKeys: ");
		System.out.println(map.keysToString());
		System.out.println(map);
	}

	public static void testTable() {
		System.out.println("\n////// Testing HashTable \\\\\\");
		HashTable table = new HashTable();
		print(table);
		table.add("Aziz", 18);
		table.add("Ahmed", 20);
		table.add("Sondos", 26);
		table.add("Salsabil", 24);
		table.add("Hanan", 50);
		table.add("Tarek", 56);
		table.add("Saja", 4);
		print(table);
		table.add("aziz", 18);
		table.add("ahmed", 20);
		table.add("sondos", 26);
		table.add("salsabil", 24);
		table.add("hanan", 50);
		table.add("tarek", 56);
		table.add("saja", 4);
		print(table);
		table.set("aziz", 19);
		table.set("ahmed", 21);
		table.set("sondos", 27);
		table.set("salsabil", 25);
		table.set("hanan", 51);
		table.set("tarek", 57);
		table.set("saja", 5);

		String[] keys = table.getKeys();
		for (int i = 0; i < keys.length; i++) {
			String key = keys[i];
			System.out.println("Contains " + key + ": " + table.contains(key));
		}
		System.out.println("Contains frog: " + table.contains("frog"));
		System.out.println("Contains bla: " + table.contains("bla"));

		for (int i = 0; i < keys.length; i++) {
			String key = keys[i];
			System.out.println(key + " -> " + table.get(key));
		}
		try {
			table.get("frog");
		} catch (IllegalArgumentException e) {
			System.out.println("Exception: " + e.toString());
		}
		try {
			table.get("bla");
		} catch (IllegalArgumentException e) {
			System.out.println("Exception: " + e.toString());
		}

		print(table);
		table.remove("hanan");
		print(table);
		table.remove("aziz");
		print(table);
		table.remove("sondos");
		print(table);
		table.remove("salsabil");
		print(table);
		table.remove("tarek");
		print(table);
		table.remove("saja");
		print(table);
		table.remove("ahmed");
		print(table);

		table.clear();
		print(table);
	}

	public static void testSet() {
		System.out.println("\n////// Testing HashSet \\\\\\");
		HashSet table = new HashSet();

		print(table);
		table.add("Aziz");
		table.add("Ahmed");
		table.add("Sondos");
		table.add("Salsabil");
		table.add("Hanan");
		table.add("Tarek");
		table.add("Saja");
		print(table);
		table.add("aziz");
		table.add("ahmed");
		table.add("sondos");
		table.add("salsabil");
		table.add("hanan");
		table.add("tarek");
		table.add("saja");
		print(table);
		table.add("Aziz");
		table.add("Ahmed");
		table.add("Sondos");
		table.add("Salsabil");
		table.add("Hanan");
		table.add("Tarek");
		table.add("Saja");
		print(table);

		String[] keys = table.getKeys();
		for (int i = 0; i < keys.length; i++) {
			String key = keys[i];
			System.out.println("Contains " + key + ": " + table.contains(key));
		}
		System.out.println("Contains frog: " + table.contains("frog"));
		System.out.println("Contains bla: " + table.contains("bla"));

		print(table);
		table.remove("hanan");
		print(table);
		table.remove("aziz");
		print(table);
		table.remove("sondos");
		print(table);
		table.remove("salsabil");
		print(table);
		table.remove("tarek");
		print(table);
		table.remove("saja");
		print(table);
		table.remove("ahmed");
		print(table);

		table.clear();
		print(table);
	}
}
