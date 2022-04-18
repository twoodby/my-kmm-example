import SwiftUI
import myshared

@main
struct iOSApp: App {
	var body: some Scene {
		WindowGroup {
			ContentView(viewModel: <#T##ViewModel#>)
		}
	}
}


enum State {
    case loading
    case success(ComicModel)
    case error
}


class ViewModel: ObservableObject {

    let getLatesteComicUseCase = GetLatestComicUseCase(xkcdApi: XkcdApi())
            
    @Published var comic = State.loading
        
    init() {
        self.comic = .loading
        getLatestComicUseCase.run { fetchedComic, error in
            if fetchedComic != nil {
                self.comic = .success(fetchedComic!)
            } else {
                self.comic = .error
            }
        }
    }
}
