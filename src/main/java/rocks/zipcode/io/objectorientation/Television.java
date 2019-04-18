package rocks.zipcode.io.objectorientation;

public class Television {

    TVChannel channel;
    Integer TVChannelNumber;
    Boolean isOn = false;

    public void turnOn() {
        isOn = true;
    }

    public void setChannel(Integer channel) {

        if (isOn) {
            this.TVChannelNumber = channel;
        } else {
            throw new IllegalStateException();
        }
    }

    public TVChannel getChannel() {

        return TVChannel.values()[this.TVChannelNumber];
    }
}
