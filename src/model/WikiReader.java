/**
 * WikiReaderクラス
 * ファイルベースWikiアプリのファイル読込処理を実装する
 * @author　Say Consulting Group
 * @version　1.0.0
 */

package model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import dto.WikiDto;

public class WikiReader {

  /**
   * getAllメソッド
   * 全てのwikiを読み込み、ArrayListとして返す
   * 
   * @return WikiDtoのリスト
   */
  public static List<WikiDto> getAll() {
    // 戻り値のArrayListを生成
    ArrayList<WikiDto> list = new ArrayList<WikiDto>();
    
    // wiki格納フォルダの情報を取得
    File file = new File("wiki");

    // wikiファイルの配列を取得
    File files[] = file.listFiles();//wiki2のなかにあるふぁいるの配列をさくせい。よみこんでいる

    // 連番のidを付けてArrayListにwikiを追加
    int id = 1;
    for (File item : files) {
      WikiDto wiki = new WikiDto(id, item);
      list.add(wiki);
      id++;
    }

    return list;
  }
}
