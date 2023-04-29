import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import document.BasicStringVisitor;
import document.Document;
import document.HtmlStringVisitor;
import document.MarkdownStringVisitor;
import document.element.BasicText;
import document.element.BoldText;
import document.element.Heading;
import document.element.HyperText;
import document.element.Paragraph;

/**
 * This class is a test class testing visitors.
 */
public class TestVisitor{

    private Document document; // a document

    /**
     * Initizlize setting
     */
    @Before
    public void init(){
        document = new Document();       
        document.add(new BasicText("This is BasicText"));
        document.add(new BoldText("This is BoldText!"));
        document.add(new Heading("Heading with level 1", 1));
        document.add(new HyperText("HyperText", "http://127.0.0.1:4000"));

        Paragraph p = new Paragraph();
        p.add(new BasicText("This is BasicText"));
        p.add(new BoldText("This is BoldText!"));
        p.add(new Heading("Heading with level 2", 2));
        p.add(new HyperText("HyperText", "http://127.0.0.1:5000"));

        document.add(p); 
    }

    /**
     * Test WordCounterVisitor()
     */
    @Test
    public void testWordCounterVisitor(){
        assertEquals(22, document.countWords());
        document.add(new BasicText("word"));
        assertEquals(23, document.countWords());
        document.add(new BasicText("two word"));
        assertEquals(25, document.countWords());
    }

    /**
     * Test BasicStringVisitor()
     */
    @Test
    public void testBasicStringVisitor(){
        StringBuilder expected = new StringBuilder();
        expected.append("This is BasicText ");
        expected.append("This is BoldText! ");
        expected.append("Heading with level 1 ");
        expected.append("HyperText ");
        expected.append("This is BasicText ");
        expected.append("This is BoldText! ");
        expected.append("Heading with level 2 ");
        expected.append("HyperText");

        assertEquals(expected.toString(), document.toText(new BasicStringVisitor()));
    }

    /**
     * Test HtmlStringVisitor()
     */
    @Test
    public void testHtmlStringVisitor(){
        StringBuilder expected = new StringBuilder();
        expected.append("This is BasicText\n");
        expected.append("<b>This is BoldText!</b>\n");
        expected.append("<h1>Heading with level 1</h1>\n");
        expected.append("<a href=\"http://127.0.0.1:4000\">HyperText</a>\n");
        expected.append("<p>This is BasicText\n");
        expected.append("<b>This is BoldText!</b>\n");
        expected.append("<h2>Heading with level 2</h2>\n");
        expected.append("<a href=\"http://127.0.0.1:5000\">HyperText</a>\n</p>");

        assertEquals(expected.toString(), document.toText(new HtmlStringVisitor()));
    }

    /**
     * Test MarkdownStringVisitor()
     */
    @Test
    public void testMarkdownStringVisitor(){
        StringBuilder expected = new StringBuilder();
        expected.append("This is BasicText\n");
        expected.append("**This is BoldText!**\n");
        expected.append("# Heading with level 1\n");
        expected.append("[HyperText](http://127.0.0.1:4000)\n");
        expected.append("\nThis is BasicText\n");
        expected.append("**This is BoldText!**\n");
        expected.append("## Heading with level 2\n");
        expected.append("[HyperText](http://127.0.0.1:5000)");

        assertEquals(expected.toString(), document.toText(new MarkdownStringVisitor()));
    }
}