package document;

import java.util.regex.Pattern;

import document.element.BasicText;
import document.element.BoldText;
import document.element.Heading;
import document.element.HyperText;
import document.element.ItalicText;
import document.element.Paragraph;

/**
 * WordCountVisitor is a vistor class counting the number of words 
 * that are in a document.
 */
public class WordCountVisitor implements DocumentVisitor<Integer>{

    // build a Pattern to record the regrex
    public static final Pattern PATTERN = Pattern.compile(" ");

    @Override
    public Integer visitBasicText(BasicText current) {
        return PATTERN.split(current.getText().trim()).length;
    }

    @Override
    public Integer visitBoldText(BoldText current) {
        return PATTERN.split(current.getText().trim()).length;
    }

    @Override
    public Integer visitHeading(Heading current) {
        return PATTERN.split(current.getText().trim()).length;
    }

    @Override
    public Integer visitHyperText(HyperText current) {
        return PATTERN.split(current.getText().trim()).length;
    }

    @Override
    public Integer visitItalicText(ItalicText current) {
        return PATTERN.split(current.getText().trim()).length;
    }

    @Override
    public Integer visitParagraph(Paragraph current) {
        return PATTERN.split(current.getText().trim()).length;
    }
}
