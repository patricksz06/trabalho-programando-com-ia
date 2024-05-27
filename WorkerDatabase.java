import java.io.*;
import java.util.HashMap;

public class WorkerDatabase {
    private static final String FILE_NAME = "workers.txt";
    private HashMap<String, Worker> workers;

    public WorkerDatabase() {
        workers = new HashMap<>();
        loadWorkers();
    }

    public void addOrUpdateWorker(Worker worker) {
        workers.put(worker.getCpf(), worker);
        saveWorkers();
    }

    private void loadWorkers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            workers = (HashMap<String, Worker>) ois.readObject();
        } catch (Exception e) {
            workers = new HashMap<>();
        }
    }

    private void saveWorkers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(workers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Worker getWorker(String cpf) {
        return workers.get(cpf);
    }
}
