
# Observer Pattern

# Subject aka Observable
class Subject:
    def register_observer(self, observer):
        raise NotImplementedError
    def remove_observer(self, observer):
        raise NotImplementedError
    def notify_observers(self):
        raise NotImplementedError
# Observer aka Subscriber
class Observer:
    def update(self, temp):
        raise NotImplementedError


# ZooKeeper
class ZooKeeper(Subject):
    def __init__(self):
        self.status = None
        self.observers = []
    def register_observer(self, observer):
        self.observers.append(observer)
    def remove_observer(self, observer):
        self.observers.remove(observer)
    def notify_observers(self):
        for observer in self.observers:
            observer.update(self.status)
            
    def status_changed(self):
        self.notify_observers()
        
    def wakeUpAnimal(self, animal, status):
        print('zoo keeper wakes up',animal.getName(),', Type:',animal.getType(),',', animal.wakeup())
        self.setStatus(status)
        
        
    def rollCallAnimal(self, animal, status):
        self.setStatus(status)

    
    def feed(self, animal, status):
        print('zoo keeper feeds',animal.getName(),', Type:',animal.getType(),',', animal.eat())
        self.setStatus(status)
        
    def exerciseAnimal(self, animal, status):
        print('zoo keeper exercises',animal.getName(),', Type:',animal.getType(),',', animal.roam())
        self.setStatus(status)

    def shutDownZoo(self, animal, status):
        print('zoo keeper shuts down zoo')
        self.setStatus(status)
    
    def setStatus(self, status):
        self.status = status
        self.status_changed()

# ZooAnnouncer
class ZooAnnouncer(Observer):
    def __init__(self, zoo_keeper):
        self.zoo_keeper = zoo_keeper
        self.zoo_keeper.register_observer(self)
        self.status = None
    def update(self, status):
        self.status = status
        print('Anouncer: zoo keeper is', self.status)
        