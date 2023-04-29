package document.element;

import document.DocumentVisitor;

/**
 * Interface that represents an element in our document.
 */
public interface TextElement {

  /**
   * Returns the text contained within the element.
   * 
   * @return the text
   */
  public String getText();

  /**
   * Allow to pass itself as an argument and apply to a speicif visitor of DocumentVisitor
   * @param <R>  the type of the return parameter for the  visit
   * @param visitor a speicif visitor of DocumentVisitor
   * @return a type that the visitor return
   */
  public <R> R accept(DocumentVisitor<R> visitor);
}
