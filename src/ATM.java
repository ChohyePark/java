import java.util.Random;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Bank[][] arrBank = new Bank[3][100];
        int[] arCount = new int[3];
        String message = "1. 신한은행\n2. 국민은행\n3. 카카오뱅크\n4. 나가기";
        String menu = "1. 계좌개설\n2. 입금하기\n3. 출금하기\n4. 잔액조회\n5. 계좌번호 찾기\n6. 은행 선택 메뉴로 돌아가기";
        Scanner sc = new Scanner(System.in);
        String account = "", password = null, phoneNumber = null, customer = null;
        Bank user = null;
        int money = 0;

        int i = 0, choice = 0;

        endLoop:
        while (true) {
            System.out.println(message);
            i = sc.nextInt();
            outerLoop:
            if (i == 1) {
                System.out.println(menu);
                choice = sc.nextInt();
                if (choice == 1) {
                    System.out.println("고객 이름을 입력해주세요 : ");
                    customer = sc.next();
                    System.out.println("핸드폰 번호를 입력해주세요 : ");
                    phoneNumber = sc.next();
                    if (checkPhoneNumber(arrBank, phoneNumber)) {
                        System.out.println("중복 핸드폰 번호가 존재합니다.");
                        break outerLoop;
                    }
                    account = createNewAccount();
                    if (!checkAccount(arrBank, account)) {
                        System.out.println("이미 존재하는 계좌번호 입니다");
                        break outerLoop;
                    }
                    System.out.println("계좌번호는 " + account + " 입니다.");
                    System.out.println("비밀번호를 입력해주세요");
                    password = sc.next();
                    user = new Shinhan(customer, password, phoneNumber, account);
                    arrBank[0][arCount[0]++] = user;
                    System.out.println("계좌 개설이 완료 되었습니다.");
                } else if (choice == 2) {
                    System.out.println("계좌번호를 입력해주새요");
                    String loginAccount = sc.next();
                    System.out.println("비밀번호를 입력해주세요");
                    String loginPassword = sc.next();
                    Bank loginUser = loginUser(arrBank[0], loginAccount, loginPassword);
                    if (loginUser == null) {
                        System.out.println("로그인 실패");
                        break outerLoop;
                    }
                    System.out.println("얼마를 입금하시겠습니까?");
                    money = sc.nextInt();
                    user.deposit(money);
                } else if (choice == 3) {
                    System.out.println("계좌번호를 입력해주세요");
                    account = sc.next();
                    System.out.println("비밀번호를 입력해주세요");
                    password = sc.next();
                    Bank loginUser = loginUser(arrBank[0], account, password);
                    if (loginUser == null) {
                        System.out.println("로그인 실패");
                        break outerLoop;
                    }
                    System.out.println("얼마를 출금하시겠습니까?");
                    money = sc.nextInt();
                    if (!loginUser.withdraw(money)) {
                        System.out.println("잔액이 부족합니다");
                    }
                    System.out.println("출금이 완료 되었습니다.");
                } else if (choice == 4) {
                    System.out.println("계좌번호를 입력해주새요");
                    account = sc.next();
                    System.out.println("비밀번호를 입력해주세요");
                    password = sc.next();
                    ;
                    Bank loginUser = loginUser(arrBank[0], account, password);
                    if (loginUser == null) {
                        System.out.println("로그인 실패");
                        break outerLoop;
                    }
                    System.out.println("현재 계좌에 " + loginUser.getBalance() + "원 있습니다.");
                } else if (choice == 5) {
                    System.out.println("핸드폰 번호를 입력해주세요");
                    phoneNumber = sc.next();
                    System.out.println(findAccount(arrBank[0], phoneNumber));
                } else if (choice == 6) {
                    break outerLoop;
                }
            } else if (i == 2) {
                System.out.println(menu);
                choice = sc.nextInt();
                if (choice == 1) {
                    System.out.println("고객 이름을 입력해주세요 : ");
                    customer = sc.next();
                    System.out.println("핸드폰 번호를 입력해주세요 : ");
                    phoneNumber = sc.next();
                    if (checkPhoneNumber(arrBank, phoneNumber)) {
                        System.out.println("중복 핸드폰 번호가 존재합니다.");
                        break outerLoop;
                    }
                    account = createNewAccount();
                    if (!checkAccount(arrBank, account)) {
                        System.out.println("이미 존재하는 계좌번호 입니다");
                        break outerLoop;
                    }
                    System.out.println("계좌번호는 " + account + " 입니다.");
                    System.out.println("비밀번호를 입력해주세요");
                    password = sc.next();
                    user = new Kookmin(customer, password, phoneNumber, account);
                    arrBank[1][arCount[1]++] = user;
                    System.out.println("계좌 개설이 완료 되었습니다.");
                } else if (choice == 2) {
                    System.out.println("계좌번호를 입력해주새요");
                    String loginAccount = sc.next();
                    System.out.println("비밀번호를 입력해주세요");
                    String loginPassword = sc.next();
                    Bank loginUser = loginUser(arrBank[1], loginAccount, loginPassword);
                    if (loginUser == null) {
                        System.out.println("로그인 실패");
                        break outerLoop;
                    }
                    System.out.println("얼마를 입금하시겠습니까?");
                    money = sc.nextInt();
                    user.deposit(money);
                } else if (choice == 3) {
                    System.out.println("계좌번호를 입력해주세요");
                    account = sc.next();
                    System.out.println("비밀번호를 입력해주세요");
                    password = sc.next();
                    Bank loginUser = loginUser(arrBank[1], account, password);
                    if (loginUser == null) {
                        System.out.println("로그인 실패");
                        break outerLoop;
                    }
                    System.out.println("얼마를 출금하시겠습니까?");
                    money = sc.nextInt();
                    if (!loginUser.withdraw(money)) {
                        System.out.println("잔액이 부족합니다");
                    }
                    System.out.println("출금이 완료 되었습니다.");
                } else if (choice == 4) {
                    System.out.println("계좌번호를 입력해주새요");
                    account = sc.next();
                    System.out.println("비밀번호를 입력해주세요");
                    password = sc.next();
                    ;
                    Bank loginUser = loginUser(arrBank[1], account, password);
                    if (loginUser == null) {
                        System.out.println("로그인 실패");
                        break outerLoop;
                    }
                    System.out.println("현재 계좌에 " + loginUser.getBalance() + "원 있습니다.");
                } else if (choice == 5) {
                    System.out.println("핸드폰 번호를 입력해주세요");
                    phoneNumber = sc.next();
                    System.out.println(findAccount(arrBank[1], phoneNumber));
                } else if (choice == 6) {
                    break outerLoop;
                }
            } else if (i == 3) {
                System.out.println(menu);
                choice = sc.nextInt();
                if (choice == 1) {
                    System.out.println("고객 이름을 입력해주세요 : ");
                    customer = sc.next();
                    System.out.println("핸드폰 번호를 입력해주세요 : ");
                    phoneNumber = sc.next();
                    if (checkPhoneNumber(arrBank, phoneNumber)) {
                        System.out.println("중복 핸드폰 번호가 존재합니다.");
                        break outerLoop;
                    }
                    account = createNewAccount();
                    if (!checkAccount(arrBank, account)) {
                        System.out.println("이미 존재하는 계좌번호 입니다");
                        break outerLoop;
                    }
                    System.out.println("계좌번호는 " + account + " 입니다.");
                    System.out.println("비밀번호를 입력해주세요");
                    password = sc.next();
                    user = new KaKao(customer, password, phoneNumber, account);
                    arrBank[2][arCount[2]++] = user;
                    System.out.println("계좌 개설이 완료 되었습니다.");
                } else if (choice == 2) {
                    System.out.println("계좌번호를 입력해주새요");
                    String loginAccount = sc.next();
                    System.out.println("비밀번호를 입력해주세요");
                    String loginPassword = sc.next();
                    Bank loginUser = loginUser(arrBank[2], loginAccount, loginPassword);
                    if (loginUser == null) {
                        System.out.println("로그인 실패");
                        break outerLoop;
                    }
                    System.out.println("얼마를 입금하시겠습니까?");
                    money = sc.nextInt();
                    user.deposit(money);
                } else if (choice == 3) {
                    System.out.println("계좌번호를 입력해주세요");
                    account = sc.next();
                    System.out.println("비밀번호를 입력해주세요");
                    password = sc.next();
                    Bank loginUser = loginUser(arrBank[2], account, password);
                    if (loginUser == null) {
                        System.out.println("로그인 실패");
                        break outerLoop;
                    }
                    System.out.println("얼마를 출금하시겠습니까?");
                    money = sc.nextInt();
                    if (!loginUser.withdraw(money)) {
                        System.out.println("잔액이 부족합니다");
                        break outerLoop;
                    }
                    System.out.println("출금이 완료 되었습니다.");
                } else if (choice == 4) {
                    System.out.println("계좌번호를 입력해주새요");
                    account = sc.next();
                    System.out.println("비밀번호를 입력해주세요");
                    password = sc.next();
                    ;
                    Bank loginUser = loginUser(arrBank[2], account, password);
                    if (loginUser == null) {
                        System.out.println("로그인 실패");
                        break outerLoop;
                    }
                    System.out.println("현재 계좌에 " + loginUser.getBalance() + "원 있습니다.");
                } else if (choice == 5) {
                    System.out.println("핸드폰 번호를 입력해주세요");
                    phoneNumber = sc.next();
                    System.out.println(findAccount(arrBank[2], phoneNumber));
                } else if (choice == 6) {
                    break outerLoop;
                }
            } else if (i == 4) {
               break ;
            }
        }
    }

    public static String createNewAccount() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        String accountNumber;
        int[] tmpAccount = new int[6];
        for (int i = 0; i < tmpAccount.length; i++) {
            sb.append(random.nextInt(9));
        }
        accountNumber = sb.toString();
        return accountNumber;
    }

    public static boolean checkAccount(Bank[][] banks, String account) {
        for (Bank[] arrBank : banks) {
            if (arrBank != null) {
                for (Bank bank : arrBank) {
                    if (bank != null && bank.getAccount().equals(account)) {
                        return false;
                    }
                }
            }

        }
        return true;
    }

    public static boolean checkPhoneNumber(Bank[][] banks, String phoneNumber) {
        for (Bank[] arrBank : banks) {
            if (arrBank != null) {
                for (Bank bank : arrBank) {
                    if (bank != null && bank.getPhoneNumber().equals(phoneNumber)) {
                        return true;
                    }
                }
            }

        }
        return false;
    }


    public static Bank loginUser(Bank[] bankName, String account, String password) {
        if (bankName == null) {
            return null;
        }
        for (Bank bank : bankName) {
            if (bank != null && bank.getAccount().equals(account) && bank.getPassWord().equals(password)) {
                return bank;
            }
        }
        return null;
    }

    public static String findAccount(Bank[] banks, String phoneNumber) {
        for (Bank bank : banks) {
            if (bank != null && bank.getPhoneNumber().equals(phoneNumber)) {
                return bank.getAccount();
            }
        }
        return "계좌번호가 존재하지 않습니다.";
    }
}


