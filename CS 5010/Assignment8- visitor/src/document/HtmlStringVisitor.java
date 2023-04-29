package document;

import java.util.List;

import document.element.BasicText;
import document.element.BoldText;
import document.element.Heading;
import document.element.HyperText;
import document.element.ItalicText;
import document.element.Paragraph;

/*
 * HtmlStringVisitor is a vistor class generating an HTML version 
 * of the document.
 */
public class HtmlStringVisitor implements DocumentVisitor<String>{
    @Override
    public String visitBasicText(BasicText current) {
        return current.getText() + "\n";
    }

    @Override
    public String visitBoldText(BoldText current) {
        StringBuilder sb = new StringBuilder();

        sb.append("<b>");
        sb.append(current.getText());
        sb.append("</b>\n");

        return sb.toString();
    }

    @Override
    public String visitHeading(Heading current) {
        StringBuilder sb = new StringBuilder();

        sb.append("<h"); sb.append(current.getLevel());sb.append(">");
        sb.append(current.getText());
        sb.append("</h"); sb.append(current.getLevel());sb.append(">\n");

        return sb.toString();
    }

    @Override
    public String visitHyperText(HyperText current) {
        StringBuilder sb = new StringBuilder();

        sb.append("<a href=\"");sb.append(current.getUrl()); sb.append("\">");
        sb.append(current.getText());
        sb.append("</a>\n");

        return sb.toString();
    }

    @Override
    public String visitItalicText(ItalicText current) {
        StringBuilder sb = new StringBuilder();
        
        sb.append("<i>");
        sb.append(current.getText());
        sb.append("</i>\n");

        return sb.toString();
    }

    @Override
    public String visitParagraph(Paragraph current) {
        StringBuilder sb = new StringBuilder();
        List<BasicText> content = current.getContent();

        sb.append("<p>");
        for (BasicText e: content){
            sb.append(e.accept(this));
        }
        sb.append("</p>\n");

        return sb.toString();
    }
}
