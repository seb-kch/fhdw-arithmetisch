package tokens;

import basic.TextConstants;

public class EndToken implements Token {
    @Override
    public String toString() {
        return TextConstants.ENDOFEXPRESSION;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof EndToken;
    }
}
