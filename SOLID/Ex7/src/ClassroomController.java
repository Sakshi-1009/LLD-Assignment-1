public class ClassroomController {
    private final DeviceRegistry reg;

    public ClassroomController(DeviceRegistry reg) { this.reg = reg; }

    public void startClass() {
        InputDevice input = reg.getFirst(InputDevice.class);
        if (input instanceof PowerDevice) ((PowerDevice) input).powerOn();
        input.connectInput("HDMI-1");

        BrightnessDevice lights = reg.getFirst(BrightnessDevice.class);
        lights.setBrightness(60);

        TemperatureDevice ac = reg.getFirst(TemperatureDevice.class);
        ac.setTemperatureC(24);

        ScannerDevice scan = reg.getFirst(ScannerDevice.class);
        System.out.println("Attendance scanned: present=" + scan.scanAttendance());
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");
        reg.getFirst(Projector.class).powerOff();
        reg.getFirst(LightsPanel.class).powerOff();
        reg.getFirst(AirConditioner.class).powerOff();
    }
}
