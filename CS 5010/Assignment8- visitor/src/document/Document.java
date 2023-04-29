package document;

import java.util.ArrayList;
import java.util.List;

import document.element.TextElement;
/**
 * This is a class to represent a generic document.
 */
public class Document {
  // a list to sotre text elements
  private List<TextElement> content;
  /**
   * Constructor of Document
   */
  public Document() {
    content = new ArrayList<>();
  }

  /**
   * Add a text element to content
   * @param e a text elment
   */
  public void add(TextElement e) {
    content.add(e);
  }

  /**
   * Returns the number of words in the document.
   * @return number of words
   */
  public int countWords(){
    int count = 0;
    WordCountVisitor visitor = new WordCountVisitor();
    for (TextElement e: content){
      count += e.accept(visitor);
    }

    return count;
  }

  /**
   *  Takes one of these "string visitors" as a parameter. 
   *  String visitors should accumulate their result and 
   *  return it when toString is called on the visitor.
   * @param visitor a string visitor
   * @return the content in String
   */
  public String toText(DocumentVisitor<String> visitor){
    StringBuilder sb = new StringBuilder();
    for (TextElement e: content){
      sb.append(e.accept(visitor));
    }

    return sb.toString().trim();
  }
}
