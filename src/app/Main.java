/**
 * ファイルベースWikiアプリ
 * 
 * Wikiアプリ開発02 - 読み込んだwikiに連番を付けよう！
 *
 * Mainクラス
 * ファイルベースWikiアプリの実行エントリポイントを持つクラス
 * @author　Say Consulting Group
 * @version　1.0.0
 */

package app;

import java.util.List;

import dto.WikiDto;
import model.WikiReader;

public class Main {

  /**
   * mainメソッド
   * ファイルベースwikiアプリのエントリポイント
   * @param args コマンドライン引数(未使用)
   */
  public static void main(String[] args) {

    // ウェルカムメッセージ表示
    System.out.println("マイwikiアプリへようこそ！\n");

    // wikiのリスト読み込み
    List<WikiDto> list = WikiReader.getAll();

    // 読み込んだwikiを全て表示する
    for (WikiDto item : list) {
      System.out.println(item.toString());
    }
  }
}
