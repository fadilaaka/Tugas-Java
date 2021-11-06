import java.util.*;

public class Mahasiswa {
	static int n, pilih, banyaknya, add;
	static String[] nama_mahasiswa;
	static String temp;
	
	public static void Opening() {
		System.out.println("|============================================|");
		System.out.println("|Program Nama Mahasiswa (Sorting & Searching)|");
		System.out.println("|============================================|");
	}
	
	public static void Looping_Menu() {
		do {
			System.out.println("[1] Tambah Mahasiswa");
			System.out.println("[2] Urutkan Mahasiswa");
			System.out.println("[3] Pencarian Nama Mahasiswa");
			System.out.println("[4] Show List Mahasiswa");
			System.out.println("[5] Exit");
			System.out.print("Input (Angka) : ");
			pilih = Integer.parseInt(System.console().readLine());
			Mahasiswa select_menu = new Mahasiswa();
			
			if(pilih == 1) {
				select_menu.add_mahasiswa();
			} else if(pilih == 2) {
				select_menu.sorting_mahasiswa();
			} else if(pilih == 3) {
				select_menu.search_nama();
			} else if(pilih == 4) {
				select_menu.show_list(nama_mahasiswa);
			} else if(pilih == 5) {
				select_menu.Exit();
			} else {
				System.out.println("Error : input not found in menu, please try again");
				System.out.println("");
			}
		} while(pilih != 5);		
	}
	
	// Tambah Nama
	public static void add_mahasiswa() {
		System.out.println("");
		if(nama_mahasiswa == null) {
			System.out.println("= Tambah Mahasiswa =");
			System.out.print("Berapa mahasiswa : ");
			n = Integer.parseInt(System.console().readLine());
			nama_mahasiswa = new String[n];
			for(int i=0; i<n; i++) {
				System.out.print("Masukkan nama mahasiswa ke-"+(i+1)+" : ");
				nama_mahasiswa[i] = System.console().readLine();
			}
		} else {
			String[] tambah;
			
			System.out.print("Berapa mahasiswa : ");
			n = Integer.parseInt(System.console().readLine());
			tambah = new String[n];
			for(int i=0; i<n; i++) {
				System.out.print("Masukkan nama mahasiswa ke-"+(i+1)+" : ");
				tambah[i] = System.console().readLine();
			}

			int temp1 = nama_mahasiswa.length;
			int temp2 = tambah.length;
			int temp3 = temp1 + temp2;
	  
			String[] temp_mahasiswa = new String[temp3];
			
			for (int i=0; i<temp1; i+=1) {
				temp_mahasiswa[i] = nama_mahasiswa[i];
			}
			for (int i=0; i<temp2; i+=1) {
				temp_mahasiswa[temp1 + i] = tambah[i];
			}
			nama_mahasiswa = temp_mahasiswa;
		}
		System.out.println("");
		System.out.println("= List Mahasiswa =");
		for(int i=0; i<nama_mahasiswa.length; i++) {
			System.out.print((i+1) + ". " + nama_mahasiswa[i]+ "\n");
		}
		System.out.println("");
	}
	
	// Sorting Nama
	public static void sorting_mahasiswa() {
		if(nama_mahasiswa == null) {
			System.out.println("Error : Nama Mahasiswa belum tersedia");
			System.out.println("");
		} else {
			String temp;
			System.out.println("==> Sebelum Sorting <==");
			for(int i=0;i<nama_mahasiswa.length;i++) {
				System.out.println((i+1) + ". "+nama_mahasiswa[i]);
			}
			System.out.println("");
			for (int i = 0; i < nama_mahasiswa.length - 1; i++) {
				for (int j = i+1; j < nama_mahasiswa.length; j++) {
					if (nama_mahasiswa[i].compareTo(nama_mahasiswa[j]) > 0) {
						temp = nama_mahasiswa[i];
						nama_mahasiswa[i] = nama_mahasiswa[j];
						nama_mahasiswa[j] = temp;
					}
				}
			}
			System.out.println("==> Nama telah disorting <==");
			for(int i=0;i<nama_mahasiswa.length;i++) {
				System.out.println((i+1) + ". "+nama_mahasiswa[i]);
			}
			System.out.println("");
		}
	}
	
	// Searching Nama
	public static int binary_search(String[] list, String x) {
		int i=0, n=list.length-1;
		while(i <= n) {
			int m = i+(n-i)/2;
			int res = x.compareTo(list[m]);
			
			if(res == 0) {
				return m;
			} else if (res > 0) {
				i = m+1;
			} else {
				n = m-1;
			}
		}
		return -1;
	}
	public void search_nama() {
		if (nama_mahasiswa == null) {
			System.out.println("Error : Nama Mahasiswa belum tersedia");
			System.out.println("");
		} else {
			System.out.print("Cari nama mahasiswa : ");
			String cari_nama = System.console().readLine();
			int result = binary_search(nama_mahasiswa, cari_nama);
			if (result == -1) {
				System.out.println("Error : Nama mahasiswa tidak ada");
				System.out.println("");
			} else {
				System.out.println("Posisi nama " + cari_nama + " berada pada urutan ke-" + (result+1));
				System.out.println("");
			}
		}
	}
	
	// Tampilkan Nama Mahasiswa
	public static void show_list(String[] list) {
		if (nama_mahasiswa == null) {
			System.out.println("= Nama Mahasiswa belum tersedia =");
			System.out.println("");
		} else {
			n = list.length;
			System.out.println("");
			System.out.println(">> Daftar Nama Mahasiswa <<");
			for(int i=0;i<n;i++) {
				System.out.println((i+1) + ". "+list[i]);
			}
			System.out.println("");
		}
	}
	
	// Exit
	public static void Exit() {
		System.out.println("|==============================================|");
		System.out.println("| Terima kasih telah menggunakan program (^_^) |");
		System.out.println("|==============================================|");
	}
	
	public static void main(String[] args) {
		Opening();
		Looping_Menu();
	}
}