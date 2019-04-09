package controller;

import java.util.Scanner;

import domain.ProductVO;
import domain.UserDTO;
import persistence.VendingDAO;
import view.VMView;

public class VMController {

	public static void main(String[] args) {
		String[] names = {"콜라", "사이다", "환타", "웰치스", "식혜"};
		int[] prices = {800, 700, 1000, 1500, 1200};
		
		VendingDAO dao = new VendingDAO() {};
		
		for (int i = 0; i < prices.length; i++) {
			dao.addProduct(new ProductVO(i, names[i], prices[i], 10));
		}
//		View 객체를 생성해서 제품정보들을 출력
		VMView view = new VMView();
		view.displayProducts(dao.getProductList());
		
//		UserDTO 객체를 생성해서 사용자에게 입력받은 값을 설정
		UserDTO user = new UserDTO();
		Scanner s1 = new Scanner(System.in);
		while(true) {
			view.inputInfo(user);
		
//		결과 출력
			view.displayResult(dao.selectProduct(user), user);
			System.out.print("* 계속해서 제품을 구매하시겠습니까? (y/n)");	//view에 만들어놓고 호출하는게 좋음.
			String answer = s1.nextLine();
			if(answer.equals("n") || answer.equals("N"))
				break;
		}
		s1.close();
	}
}
