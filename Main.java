import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Streamを利用してみる

        Hunter gon = new Hunter("Gon Freecss", 12);
        Hunter killua = new Hunter("Killua Zoldyck", 12);
        Hunter kurapika = new Hunter("Kurapika", 18);
        Hunter leorio = new Hunter("Leorio Paradinight", 20);
        List<Hunter> hunters = List.of(gon, killua, kurapika, leorio);

        // 既存List表示
        System.out.println("＜既存List＞");
        for (int i = 0; i < hunters.size(); i++) {
            System.out.println(hunters.get(i).getName());
        }

        // 18歳以下のハンターの名前を大文字で降順に出力する
        System.out.println("＜新規List＞");
        hunters.stream()
                .filter(hunter -> hunter.getAge() <= 18)
                .map(hunter -> hunter.getName().toUpperCase())   // この処理でstreamの要素の型がHunter型からString型になっている？
                .sorted(Comparator.reverseOrder())
                .forEach(hunter -> System.out.println(hunter));  // 要素がString型のため、HunterクラスのgetName()は呼び出せない

        // ⇒ Streamによる処理はList自体の値には影響を与えず、中間操作中はメソッドが実行される度に、
        // 　新規のListが生成されそこに操作後の値が格納されると思われる。


    }
}
