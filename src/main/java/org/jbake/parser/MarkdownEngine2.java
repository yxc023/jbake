package org.jbake.parser;

import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;

/**
 * Created by Michael on 2017/8/3.
 */
public class MarkdownEngine2 extends MarkupEngine {
    @Override
    public void processBody(ParserContext context) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(context.getBody());
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        context.setBody(renderer.render(document));
    }
}
