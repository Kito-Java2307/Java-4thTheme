import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SimpleTimeZone;

public class Main {
    public static void main(String[] args) {
        // Streamを利用してみる

        Hunter gonn = new Hunter("Gonn", 12);
        Hunter kirua = new Hunter("Kirua", 12);
        Hunter kurapika = new Hunter("Kurapika", 18);
        Hunter reorio = new Hunter("Reorio", 20);
        List<Hunter> hunters = List.of(gonn, kirua, kurapika, reorio);

        System.out.println("＜既存List＞");
        // 既存List表示
        for (int i = 0; i < hunters.size(); i++) {
            System.out.println(hunters.get(i).getName());
        }

        System.out.println("============");
        System.out.println("＜新規List＞");

        // 18歳以下のハンターの名前を大文字で降順に出力する
        hunters.stream()
                .filter(hunter -> hunter.getAge() <= 18)
                // ↓ この処理でstreamの要素の型がHunter型からString型になっている？
                .map(hunter -> hunter.getName().toUpperCase())
                .sorted(Comparator.reverseOrder())
                // ↓ 要素がString型のため、HunterクラスのgetName()は呼び出せない
                .forEach(hunter -> System.out.println(hunter)); // メソッド参照：System.out::println

        // ⇒ Streamによる処理はList自体の値には影響を与えず、中間操作中はメソッドが実行される度に、
        // 　新規のListが生成されそこに操作後の値が格納されると思われる。


    }
}