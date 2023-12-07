/**
 * WikiDtoクラス
 * wikiデータを一つ持てるdata object(dto)
 * Java Beansの定石通り直列化用インターフェース実装
 * @author　Say Consulting Group
 * @version　1.0.0
 */

package dto;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WikiDto implements Serializable {

  private int id;       // wikiの連番
  private String title; // 題名
  private String body;  // 本文

  /**
   * 引数無しのコンストラクタ
   * @return 空のWikiDtoインスタンス
   */
  public WikiDto() {
    super();
  }

  /**
   * 引数に連番とwikiファイルを指定するコンストラクタ
   * @param id wikiの連番
   * @param file 読み込み対象のfile
   * @return 連番とwikiが設定されたdtoインスタンス
   */
  public WikiDto(int id, File file) {
    Path path = Paths.get(file.getAbsolutePath());

    // 連番を設定
    this.id = id;

    // wiki題名をファイルから取得してフィールドに設定 //getName ファイルのタイトルを取り出す関数
    this.title = file.getName();

    // wiki本文をファイルから取得してフィールドに設定
    // ファイルを読み込む際、IOExceptionが発生する可能性があるためtry～catch構文を使う
    try {
      this.body = Files.readString(path); //readString ファイルの内容を取り出す関数
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * indexメソッド
   * wikiの連番と題名の文字列を返す
   * @return 【連番3桁d : 題名】左記形式に整形された文字列
   */
  //メソッド 戻り値をMainの32行目に返す。
  public String index() {
    return String.format("【%3d : %s】", this.id, this.title);
  }

  /**
   * toStringメソッド
   * 上記indexメソッドの戻り値に、wiki本文を加えた文字列を返す
   * @return 【連番3桁d : 題名】+ 改行 + wiki本文
   */
  public String toString() {
    return String.format("%s\n%s\n", this.index(), this.body);
  }
}
