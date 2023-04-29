package document;

import document.element.BasicText;
import document.element.BoldText;
import document.element.Heading;
import document.element.HyperText;
import document.element.ItalicText;
import document.element.Paragraph;

/**
 * BasicStringVisitor is a vistor class generating a simple string 
 * representation of the document.
 */
public class BasicStringVisitor implements DocumentVisitor<String>{

    @Override
    public String visitBasicText(BasicText current) {
        return current.getText().trim() + " ";
    }

    @Override
    public String visitBoldText(BoldText current) {
        return current.getText().trim() + " ";
    }

    @Override
    public String visitHeading(Heading current) {
        return current.getText().trim() + " ";
    }

    @Override
    public String visitHyperText(HyperText current) {
        return current.getText().trim() + " ";
    }

    @Override
    public String visitItalicText(ItalicText current) {
        return current.getText().trim() + " ";
    }

    @Override
    public String visitParagraph(Paragraph current) {
        return current.getText().trim() + " ";
    }
}