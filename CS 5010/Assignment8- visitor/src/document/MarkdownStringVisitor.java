package document;

import java.util.List;

import document.element.BasicText;
import document.element.BoldText;
import document.element.Heading;
import document.element.HyperText;
import document.element.ItalicText;
import document.element.Paragraph;

/**
 * MarkdownStringVisitor is a vistor class generating a Markdown version 
 * of the document.
 */
public class MarkdownStringVisitor implements DocumentVisitor<String>{
    @Override
    public String visitBasicText(BasicText current) {
        return current.getText()+"\n";
    }

    @Override
    public String visitBoldText(BoldText current) {
        StringBuilder sb = new StringBuilder();

        sb.append("**");
        sb.append(current.getText());
        sb.append("**\n");

        return sb.toString();
    }

    @Override
    public String visitHeading(Heading current) {
        StringBuilder sb = new StringBuilder();

        sb.append("#".repeat(current.getLevel())); sb.append(" ");
        sb.append(current.getText());
        sb.append("\n");

        return sb.toString();
    }

    @Override
    public String visitHyperText(HyperText current) {
        StringBuilder sb = new StringBuilder();

        sb.append("["); sb.append(current.getText()); sb.append("]");
        sb.append("("); sb.append(current.getUrl()); sb.append(")\n");

        return sb.toString();
    }

    @Override
    public String visitItalicText(ItalicText current) {
        StringBuilder sb = new StringBuilder();

        sb.append("*");
        sb.append(current.getText());
        sb.append("*\n");

        return sb.toString();
    }

    @Override
    public String visitParagraph(Paragraph current) {
        StringBuilder   sb      = new StringBuilder();
        List<BasicText> content = current.getContent();
        
        sb.append("\n");
        for(BasicText e: content){
            sb.append(e.accept(this));
        }
        sb.append("\n");

        return sb.toString();
    }
}
